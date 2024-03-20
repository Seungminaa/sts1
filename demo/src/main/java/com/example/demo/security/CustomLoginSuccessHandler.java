package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	//로그인 성공후 작업
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		log.info("login success");
		List<String> roleNames = new ArrayList<>();
		//Collection<Authority> ==> List<Stirng>
		
		//해당 사람의 role정보
		auth.getAuthorities().forEach(authority -> { roleNames.add(authority.getAuthority()); }); 
		
		log.info("roleNames : " + roleNames);
		
		//어드민 롤 접속시 이동 url 다르게
		if(roleNames.contains("ROLE_ADMIN")) { // roleName 은  ROLE_ 고정해서 들어옴
			response.sendRedirect("/empList");
		}else {
			response.sendRedirect("/hello");
		}
	}
	
}
