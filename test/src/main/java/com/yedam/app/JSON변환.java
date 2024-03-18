package com.yedam.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON변환 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		// 참고 사이트
		// https://www.baeldung.com/jackson-object-mapper-tutorial
		
		ObjectMapper objectMapper = new ObjectMapper();
		// object ==> json
		EmpVO vo = new EmpVO("길동","홍");
		vo.setFirstName("길동");
		vo.setLastName("홍");
		
		String str = objectMapper.writeValueAsString(vo);
		System.out.println(str);
		
		// json ==> object
		String json = "{\"employeeId\":0,\"firstName\":\"길도\",\"lastName\":\"홍\",\"email\":null,\"hireDate\":null,\"salary\":null,\"jobId\":null,\"departmentId\":null,\"managerId\":null,\"phone\":null}";
		vo = objectMapper.readValue(str, EmpVO.class);
		
		//url ==> object
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		System.out.println(map.get("title"));
		
		// 배열 json
		String jsonCarArray = 
				  "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		//List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});

	}
}
