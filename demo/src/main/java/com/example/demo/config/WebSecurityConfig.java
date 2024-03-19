package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//config가 바뀌면 재시작 필요
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll() //security 버전에 따라 좀 다름(antMatchers) 
				.antMatchers("/empList*").hasRole("ADMIN") // hasRole 접근가능한 사람 // Forbidden, 403 -> 접근권한이 없어서 뜨는 애러
				.anyRequest().authenticated() // permitAll 접속가능한 url
			)
			.formLogin((form) -> form
				.loginPage("/login") //로그인페이지로 이동, hello 페이지 이동시 login 페이지로 이동함, 쿠키로 저장됨
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("1111")
				.password("1111")
				.roles("USER")
				.build();
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1111")
					.roles("ADMIN")
					.build();

		return new InMemoryUserDetailsManager(user,admin);
	}
}
