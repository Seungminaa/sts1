package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect    //aspect : aop 설정 , 먼저 실행
@Component //빈등록
public class LogAdvice {
	//..*Impl : Impl로 끝나는 클래스
	//AfterReturning
	
	//다른곳에도 pointcut 사용가능
	@Pointcut("execution(* com.yedam.app.emp..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void logBefore(JoinPoint jp) {
		System.out.println("[log before]");
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println(name + ":");
		if(args != null) {
			for(Object arg:args) {
				System.out.println(arg);
			}
		}
	}
}
