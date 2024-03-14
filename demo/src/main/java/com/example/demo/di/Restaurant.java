package com.example.demo.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;



@Component
@Data
@RequiredArgsConstructor //final 필드를 초기화 시켜주는 생성자를 만들어줌
@Scope("prototype")  //singletone : 요청할때마다 새로만듬, prototype : 요청할때 생성 및 삭제됨, request, session
public class Restaurant {
	
	//@Autowired
	//@Setter(onMethod_ = {@Autowired}) //setter 메소드에 autowired를 생성
	final private Chef chef;

	
	
	
}
