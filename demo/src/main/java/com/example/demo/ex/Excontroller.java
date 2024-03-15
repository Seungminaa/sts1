package com.example.demo.ex;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;

@Controller
public class Excontroller {

//	@RequestMapping("/ex2")
//	public String ex2(EX01VO vo) {
//		System.out.println(vo);
//		return "index";
//	}

//	@RequestMapping("/ex3")
//	public String ex3(ListCodeVO vo) {
//		System.out.println(vo);
//		return "index";
//	}

	// 커맨드 객체 없이 파라미터 localhost:8081/ex5?username=?&age=2
	@RequestMapping("/ex5")
	public String ex5(String username,
			@RequestParam(name = "userage", required = false, defaultValue = "10") Integer age) {
		System.out.println(username);
		System.out.println(age);
		return "index";
	}

	// @PathVariable : 파람이나 쿼리문으로 들어오는 값 가져옴(타입변환 시켜줌) -> 이름 설정가능
	@RequestMapping("/ex4/{username}/{userage}")
	public String ex4(@PathVariable String username, @PathVariable(name = "userage") int age) {
		System.out.println(username);
		System.out.println(age);
		return "index";
	}

	// 파일 업로드 처리
	@RequestMapping("/ex6") // @RequestPart 멀티파트 파일앞에 생략가능, 다중파일은 배열로 받음, 이름은 name속성의 값과 동일
	public String ex6(EmpVO vo, MultipartFile[] photos) throws IllegalStateException, IOException {
		System.out.println(vo);
		if (photos != null) {

			for (MultipartFile photo : photos) {

				if (!photo.isEmpty() || photo.getSize() > 0) { //둘중에 하나만 쓰면됨

					// 파일 생성
					File file = new File("d:/upload", photo.getOriginalFilename());
					// 파일 저장
					photo.transferTo(file);

					System.out.println("파일명 : " + photo.getOriginalFilename());
					System.out.println("파일크기 : " + photo.getSize());
					System.out.println("파일타입 : " + photo.getContentType());
					System.out.println("파일이름 : " + photo.getName());
				}
			}
		}
		return "index";
	}
}
