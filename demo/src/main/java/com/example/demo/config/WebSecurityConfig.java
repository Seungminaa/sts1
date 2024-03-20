package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.CustomAccessDeniedHandler;
import com.example.demo.security.CustomLoginSuccessHandler;

//config가 바뀌면 재시작 필요
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired UserDetailsService detailService;
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll() //security 버전에 따라 좀 다름(antMatchers) 
				.antMatchers("/empList*").hasRole("ADMIN") // hasRole 접근가능한 사람 // Forbidden, 403 -> 접근권한이 없어서 뜨는 애러
				.anyRequest().authenticated() // permitAll 접속가능한 url
			)
			.formLogin().loginPage("/login")
						.usernameParameter("userid") //파라미터값 변경
						.loginProcessingUrl("/userlogin") // user로그인 url 변경
						.successHandler(successHandler()) // 로그인 성공시 해당 핸들러 요청
			            .permitAll()
			.and()
			/*.formLogin((form) -> form
				.loginPage("/login") //로그인페이지로 이동, hello 페이지 이동시 login 페이지로 이동함, 쿠키로 저장됨
				.permitAll()
			)*/
			.logout().logoutSuccessUrl("/customLogout")  //로그아웃 성공시 핸들러와 url 둘다 설정가능
			.permitAll()             //람다식이 아닌 표현
			.and()
			//.logout((logout) -> logout.permitAll())
			//.exceptionHandling().accessDeniedHandler(accessDeniedHandler()); // 안에 bean으로 등록한 accessDeniedHandler()를 호출
			.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler()))
			.userDetailsService(detailService)
			//.csrf().disable()           //csrf 토큰 받지않음
			;
		
		
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("1111")
//				.password("1111")
//				.roles("USER")
//				.build();
//		UserDetails admin =
//				 User.withDefaultPasswordEncoder()
//					.username("admin")
//					.password("1111")
//					.roles("ADMIN")
//					.build();
//
//		return new InMemoryUserDetailsManager(user,admin);
//	}
}
