package com.example.demo.emp;

import lombok.Data;

@Data
public class searchVO {
	int start = 1;
	int end = 10;
	
	int[] employeeIds;
}
