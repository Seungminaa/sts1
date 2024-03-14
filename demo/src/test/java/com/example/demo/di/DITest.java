package com.example.demo.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class DITest {
	
	@Autowired
	private Restaurant restaurant;
	
	@Setter(onMethod_ = {@Autowired })
	private Restaurant restaurant1;
	
	@Test
	public void 스코프비교() {
		assertThat(restaurant==restaurant1).isTrue(); //비교연산자
	}
	
	//@Test
	public void test() {
		assertThat(restaurant.getChef()).isNotNull();
		//assertThat(restaurant).isNull();
		//assertThat(restaurant).isNotNull();
		//프록시 클래스
	}
}
