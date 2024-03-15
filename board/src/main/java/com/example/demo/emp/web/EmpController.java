package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	//등록페이지 이동
	@GetMapping("/emp/insert")
	public void insert() {
		
	}
	
	//등록처리 -> employees 테이블에 photo 컬럼 추가 
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo,MultipartFile photoFile) throws IllegalStateException, IOException{ // @ModelAttribute("emp") model의 이름변경
		System.out.println(vo);
		if (photoFile != null) {
			if (photoFile.getSize() > 0) {
				// 파일 생성
				File file = new File("d:/upload", photoFile.getOriginalFilename());
				// 파일 저장
				photoFile.transferTo(file);
				vo.setPhoto(photoFile.getOriginalFilename());
				System.out.println("파일명 : " + photoFile.getOriginalFilename());
				
				int result = mapper.insertEmp(vo);
				if(result>0) {
					System.out.println("등록완료");
				}
			}
		
		}
		return "redirect:/emp/list";
	}
	
	//수정페이지 이동
	@GetMapping("/emp/update")
	public void update() {
		
	}

	//수정처리
	@PostMapping("/update")
	public String update(EmpVO vo) {
		if(mapper.updateEmp(vo)>0) {
			System.out.println("수정완료");
		}
		
		return "redirect:emp/list";
	}
	
	
	//삭제처리
	@PostMapping("/delete/{employeeId}")
	public String delete(@PathVariable String employeeId) {
		
		EmpVO vo = new EmpVO();  
		vo.setEmployeeId(Integer.parseInt(employeeId));
		if(mapper.deleteEmp(vo) > 0) {
			System.out.println("삭제완료");
		};
		
		return "redirect:emp/list";
	}
	
	//상세조회
	@RequestMapping("/emp/info/{employeeId}")
	public String info(@PathVariable String employeeId, Model model) {
		
		model.addAttribute("emp",mapper.getEmpInfo(Integer.parseInt(employeeId)));
		
		System.out.println("조회완료");
		return "emp/info";
	}
	
	
	//목록페이지 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, searchVO svo){ 
		model.addAttribute("empList", mapper.getEmpList(vo,svo));
	return "emp/list"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//result로 가는 포워딩
//	@RequestMapping("/empResult") 
//	public String result() {
//		return "result";
//	}
//	
//	@PostMapping("/insert3") // 데이터 넘겨줄려면 RedirectAttributes 에 값을 담아서 페이지로 넘어가는 포워딩을 호출해 데이터를 넘김
//	public String insert3(EmpVO vo, RedirectAttributes rttr) { // 특정선언 없을시 매개변수를 넘길대 객체명의 앞글자만 소문자로
//		System.out.println("등록 : " + vo);
//		rttr.addAttribute("insertResult","성공");
//		rttr.addFlashAttribute("flashResult","한번만 사용가능"); //일회성 url 형태로 넘어감
//		return "redirect:empResult"; //result로 가는 url을 호출
//	}
//	
//	
//	
//	
//
////	@RequestMapping("/update")
////	@ResponseBody        //request.getParameter
////	public String update(@RequestParam List<String> hobby) {
////		System.out.println(hobby);
////		return "true";
////	}
//	
//	@GetMapping("/")
//	public String test() {
//		return "index"; //templates/index.html 을 찾음
//	}
	


}
