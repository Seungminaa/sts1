package com.yedam.app.콜렉션;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

// List, Set, Map
// list :           ,index   -> 순차적목록
// set : 중복값 허용안함 ,index -> 중복값허용X
// map : <k,v>, key          -> 검색
public class CollectionTest {
	public static void main(String[] args) {
		//중복값 제거
		List<Integer> list = Arrays.asList(3,3,3,5,4,6,1,2,8,89,10,9);
		System.out.println(list);
		
		// list => set
		Set s = new HashSet<>(list);
		System.out.println(s);
		
		//list<EmpVO>
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		
		emplist.add(new EmpVO("choi","aaa",20000));
		emplist.add(new EmpVO("park","caa",10000));
		emplist.add(new EmpVO("choi","aaa",20000));
		emplist.add(new EmpVO("kim","baa",5000));
		
		//equals와 hashCode를 @Override 하여 담는조건 변경
		HashSet<EmpVO> s1 = new HashSet<EmpVO>(emplist);
		System.out.println(s1);
		List<String> l2 = new ArrayList<String>();
		List<EmpVO> filterList = new ArrayList<EmpVO>();
		//필터링 : 급여가 15000이상인 사원만 검색
		for(EmpVO vo : s1) {
			if(vo.getSalary() > 15000) {
				l2.add(vo.getFirstName());
			}
		}
		filterList = s1.stream().filter(vo -> vo.getLastName().contains("b")).collect(Collectors.toList());
		
		System.out.println(filterList.get(0).getLastName());
	}

	
}
