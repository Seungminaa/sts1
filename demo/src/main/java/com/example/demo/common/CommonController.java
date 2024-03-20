package com.example.demo.common;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CommonController {
	
	//로그인 접속 애러처리
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access denied : " + auth);
		
		model.addAttribute("msg","access denied");
	}
	
	//로그아웃 성공시 url 핸들러 처리
	@GetMapping("/customLogout")
	public String customLogout() {
		log.info("logout success");
		
		return "home";
	}
}
