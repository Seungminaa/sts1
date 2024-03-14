package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	
	//의존성 주입(DI dependency Injection)
	@Autowired
	EmpMapper dao;
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody
	public List<EmpVO> ajaxEmp(){
		return dao.getEmpList(null,null);
	}

	@RequestMapping("/empList")
	public String empList(Model model){ 
		model.addAttribute("empList", dao.getEmpList(null,null));
	return "empList"; 
	}
}
