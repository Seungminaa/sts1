package com.yedam.app.상속;

import java.util.*;

import com.yedam.app.EmpVO;

public class 인터페이스활용 {
	public static void main(String[] args) {
		
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		list.add(new EmpVO("choi","aaa",20000));
		list.add(new EmpVO("park","caa",10000));
		list.add(new EmpVO("kim","baa",5000));
		
		/*new Comparator<EmpVO>(){ //익명함수로 생성

			@Override
			public int compare
			}*/
		
		//sort // 람다식으로 역순비교
		Collections.sort(list, (EmpVO o1,EmpVO o2) ->  o2.getFirstName().compareTo(o1.getFirstName()));

		for(EmpVO vo : list) {
			System.out.println(vo.getFirstName() + " : " + vo.getLastName());
		}
		
		//sort // 급여비교
				Collections.sort(list, (EmpVO o1, EmpVO o2) ->  o1.getSalary() - o2.getSalary()); // 뒤엔 비교연산만 들어감

				for(EmpVO vo : list) {
					System.out.println(vo.getLastName() + " : " + vo.getSalary());
				}
	}
}

