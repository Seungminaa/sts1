package com.example.demo.emp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperTest {
	@Autowired
	EmpMapper mapper;
	
	//@Test
	public void 사원전체조회() {
		EmpVO vo = new EmpVO();
		searchVO svo = new searchVO();
//		vo.setDepartmentId("50");
//		vo.setManagerId("103");
//		vo.setFirstName("Kevin");
//		vo.setStart(1);
//		vo.setEnd(10);
		
		svo.setEmployeeIds(new int[] {100,101,102});
		List<EmpVO> list = mapper.getEmpList(vo,svo);
		System.out.println("result : " + list.size());
		for(EmpVO emp : list) {
			System.out.println("이름은" + emp.getFirstName());
			System.out.println("아이디 : "+emp.getEmployeeId());
		}
//		assertEquals(null, null);
	}
	
	//@Test
	public void 사원단건조회() {
		int employee_id = 100;
		EmpVO vo = mapper.getEmpInfo(employee_id);
		System.out.println(vo);
//		assertEqual(employee_id, vo.getEmployeeId());
	}
	
	@Test
	public void 사원등록() {
		//객체 생성 및 초기화
		EmpVO vo = EmpVO.builder().firstName("사람").lastName("종이").email("dmg041443@naver.com").hireDate(new Date()).jobId("AD_PRES").build();
//		vo.setEmployeeId(300);
//		vo.setFirstName("사람");
//		vo.setLastName("종이");
//		vo.setEmail("dmg04144@naver.com");
//		vo.setHireDate(new Date());
//		vo.setJobId("AD_PRES");
		
		int a = mapper.insertEmp(vo);
		
		//등록된 사원조회
		System.out.println("등록된 사번 : " + vo.getEmployeeId());
		System.out.println("등록된 건수 : " + a);
		
		
		if(a >0) {
			System.out.println(a);
			System.out.println("사원등록 성공");
		}
	}
	
	//@Test
	public void 사원삭제() {
		EmpVO vo = new EmpVO();
		vo.setEmployeeId(300);
		
		int b = mapper.deleteEmp(vo);
		if(b>0) {
			System.out.println(b);
			System.out.println("사원삭제 성공");
		}
	}
	
	
	//@Test
	public void 사원통계() {
		List<Map<String, Object>> list = mapper.getStat();
		System.out.println(list);
		for(Map<String, Object> a : list) {
			System.out.println(a.get("name"));
			System.out.println(a.get("id"));
			System.out.println(a.get("cnt"));
			System.out.println(a);

		}
	}
}
