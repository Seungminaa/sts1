package com.example.demo.emp.web;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.searchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

@RestController
public class EmpRestController {
	
	@Autowired EmpService service;
	
	// 리스트 페이지로 이동
	@GetMapping("/empMng")
	public ModelAndView empMng() {
		ModelAndView mv = new ModelAndView("empMng"); 
		return mv;
	}
	
	//사원리스트 데이터를 넘겨줌
	@GetMapping("/ajax/empList")
	//@ResponseBody // vo-> json string , ajax 응답시 반드시 필요
	public Map<String,Object> empList(EmpVO vo, searchVO svo,Paging pvo) {
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		Map<String,Object> map = service.getEmpList(vo, svo);
		pvo.setTotalRecord((long)map.get("count"));
		map.put("paging", pvo);
		return map;
	}
	
	//ajax 등록 및 데이터 넘겨줌
	@PostMapping("/ajax/emp")
	public EmpVO save(@RequestBody EmpVO vo) {
		System.out.println(vo);
		service.insertEmp(vo);
		
		return vo;
	}
	
	//ajax 단건조회
	@GetMapping("/ajax/emp/{empId}")
	public EmpVO info(@PathVariable int empId) {
		return service.getEmpInfo(empId);
	}
	
	@GetMapping("/ajax/empStat")
	public List<Map<String,Object>> stat(){
		return service.getStat();
	}
}
