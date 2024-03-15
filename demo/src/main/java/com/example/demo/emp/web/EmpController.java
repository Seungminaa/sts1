package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.searchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //생성자 방식
@Controller //컨테이너 빈 등록 + 사용자요청처리 할 수 있는 커맨드 핸들러 객체로 변환
public class EmpController {
	
	
	//@Autowired
	
	final EmpMapper mapper; //의존성 주입(DI dependency Injection)
	
	@PostMapping("/insert2") // 데이터 + 상태값까지 전달가능
	public ResponseEntity<EmpVO> insert2(EmpVO vo) {
		return new ResponseEntity<EmpVO>(vo,HttpStatus.OK); // 200번
	}
	
	//result로 가는 포워딩
	@RequestMapping("/empResult") 
	public String result() {
		return "result";
	}
	
	@PostMapping("/insert3") // 데이터 넘겨줄려면 RedirectAttributes 에 값을 담아서 페이지로 넘어가는 포워딩을 호출해 데이터를 넘김
	public String insert3(EmpVO vo, RedirectAttributes rttr) { // 특정선언 없을시 매개변수를 넘길대 객체명의 앞글자만 소문자로
		System.out.println("등록 : " + vo);
		rttr.addAttribute("insertResult","성공");
		rttr.addFlashAttribute("flashResult","한번만 사용가능"); //일회성 url 형태로 넘어감
		return "redirect:empResult"; //result로 가는 url을 호출
	}
	
	@RequestMapping("/ajaxEmp") // 데이터값만 전달가능
	@ResponseBody
	public List<EmpVO> ajaxEmp(){
		return mapper.getEmpList(null,null);
	}
	
	
	
	@PostMapping("/insert")
//	@ResponseBody
	public ModelAndView insert(@ModelAttribute("emp") EmpVO vo) { // @ModelAttribute("emp") model의 이름변경
		System.out.println(vo);
		//커맨드 객체는 model에 추가됨
		//model.addAttribute("empVO",vo);
		//model.addAttribute("insertResult","success");
		//mapper.insertEmp(vo);
		
		//ModelAndView : 뷰랑 데이터,상태값을 같이 넘겨줌(상태값 안넘기면 굳이 사용할 필요없음)
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("insertResult","success");
		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR); // 500번 애러
		return mv;
	}
	
//	@RequestMapping("/update")
//	@ResponseBody        //request.getParameter
//	public String update(@RequestParam List<String> hobby) {
//		System.out.println(hobby);
//		return "true";
//	}
	
	@GetMapping("/")
	public String test() {
		return "index"; //templates/index.html 을 찾음
	}
	

	@RequestMapping("/empList")
	public String empList(Model model,EmpVO vo,searchVO svo){ 
		model.addAttribute("companyName", "<i><font color='red'>예담주식회사</font></i>");
		model.addAttribute("empList", mapper.getEmpList(vo,svo));
	return "empList"; 
	}
	
	
	
	
	
	// 03월15일
	@GetMapping("/update/{empId}") // 주소값으로 넘기는건 pathVariable 사용필요
	public String update(@PathVariable int empId) {
		System.out.println(empId);
		return "index";
	}
	
	@GetMapping("/delete") //쿼리문은 매개변수로 넣으면 됨, 뷰에서 파라미터 변수명과 매개변수명이 동일해야함
	public String delete(int employeeId,String name) {
		System.out.println(employeeId);
		System.out.println(name);
		return "index";
	}
}
