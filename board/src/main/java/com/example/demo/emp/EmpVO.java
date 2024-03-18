package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	Integer employeeId;
	String firstName;
	String lastName;
	String email;
<<<<<<< HEAD
	@DateTimeFormat(pattern = "yyyy-MM-dd")
=======
	@DateTimeFormat(pattern = "yyyy/MM/dd")
>>>>>>> branch 'main' of https://github.com/Seungminaa/sts1.git
	Date hireDate;
	Integer salary;
	String jobId;
	String departmentId;
	String managerId;
	String phone;
	String photo;
	
}
