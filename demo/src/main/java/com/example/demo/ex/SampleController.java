package com.example.demo.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//모든 데이터의 응답이 json으로 넘어감
@RestController
public class SampleController {
	
	@GetMapping(value = "/getText",produces = "application/json;charset=UTF-8")
	public String getText() {
		
		return "{\"greet\":\"안녕하세요\"}";
//		return "ㅎㅇ";
	}
	
	
	@GetMapping("/check")
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		
		if(height >150) {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
			return result;
		}else {
			result = new ResponseEntity<>(vo,HttpStatus.BAD_GATEWAY);
			return result;
		}
	}
	
	
}
