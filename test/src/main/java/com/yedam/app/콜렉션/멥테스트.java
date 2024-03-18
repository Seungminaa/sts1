package com.yedam.app.콜렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

public class 멥테스트 {
	public static void main(String[] args) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("100", "Park");
		map.put("101", "Hark");
		map.put("102", "Fark");
		
		String name = (String)map.get("101");
		
		//반복문
		for(String key :map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		//VO == Map
		List<HashMap<String,Object>> empList = new ArrayList<HashMap<String,Object>>();
		map = new HashMap<String, Object>();
		map.put("firstName", "Park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);
		
		
		
		map = new HashMap<String, Object>();
		map.put("firstName", "Hark");
		map.put("lastName", "bbb");
		map.put("salary", 40000);
		empList.add(map);
		
		for(HashMap<String,Object> key :empList) {
			System.out.println(key.get("firstName"));
			System.out.println(key.get("lastName"));
			System.out.println(key.get("salary"));
		}
		
		//filter
		
		List<HashMap<String,Object>> empList2 = new ArrayList<HashMap<String,Object>>();
		for(HashMap<String,Object> maps: empList) {
			if((int)maps.get("salary") > 15000) {
				empList2.add(maps);
			}
		}
		
		System.out.println(empList2);
		
		//stream()
		empList2 = empList.stream()
				.filter(vo -> (int)vo.get("salary") > 15000)
				.peek(System.out::println)
				.collect(Collectors.toList());
		
//		System.out.println(empList2);
	}
}
