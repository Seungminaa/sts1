package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 붙은 객체의 생성자를 만들어줌
public class EmpVO {
	 int employeeId; //int는 널 체크 불가능! Integer는 널 체크 가능!
	 final private String firstName; // final 한번생성시 변경불가, 생성할때 넣어줌
	 final private String lastName;
	 private String email;
	 private Date hireDate;
	 final private Integer salary;
	 private String jobId;
	 private String departmentId;
	 private String managerId;
	 private String phone;
	 

	 public String getFirstName() {
		return this.firstName;
	}
	 
	 public String getLastName() {
		return this.lastName;
	}
	 
	public int getSalary() {
			return this.salary;
		}

	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj; //부모 자식간의 형변환 가능
		return this.firstName.equals(vo.getFirstName()) && this.lastName.equals(vo.getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.firstName,this.lastName);
	}
	
	

}
