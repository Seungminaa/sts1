package com.sam.app.insa.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsVO {
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
