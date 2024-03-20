package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repo;
	
	@AfterEach
	public void cleanup() {
		repo.deleteAll();
	}
	
	@Test
	public void 저장_조회() {
		//기본키가 있고 없고 차이로 insert와 update가 나뉨
		
		//given
		String name = "홍길동";
		String phone = "010-2222-5555";
		
		Customer customer =  Customer.builder()
									 .name(name)
									 .phone(phone)
									 .build();
		//저장
		repo.save(customer);
		
		//리스트에 담음
		//when
		List<Customer> list = repo.findByNameLike(name);
		
		
		//then
		Customer result = list.get(0);
		assertThat(result.getName()).isEqualTo(name);
	}
}
