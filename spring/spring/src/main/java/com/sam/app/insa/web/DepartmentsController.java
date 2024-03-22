package com.sam.app.insa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sam.app.insa.service.DepartmentService;

@Controller
public class DepartmentsController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getDepartmentList")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insa/departmentslist");
		mv.addObject("list",departmentService.getList());
		
		return mv; //화면
	}
	
	
}
