package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.service.EmpService;

@SpringBootTest
public class EmpServiceTest {
	//Autowired 시 implements 되어있는 serviceImpl 찾아서 반환함
	@Autowired EmpService empService;
	
	@Test
	public void 리스트페이지조회() {
		//given
		searchVO svo = new searchVO();
		svo.setStart(1);
		svo.setEnd(10);
		EmpVO evo = new EmpVO();
		
		//when
		Map<String, Object> map = empService.getEmpList(evo, svo);
		
		//then
		System.out.println(map.get("count"));
		//값비교
		assertThat(map.get("data")).isNotEqualTo(0);
	}
	
	
}
