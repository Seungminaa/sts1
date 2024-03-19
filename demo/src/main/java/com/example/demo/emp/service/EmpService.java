package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.searchVO;

public interface EmpService {

	 Map<String,Object> getEmpList(EmpVO vo,searchVO svo);
	 EmpVO getEmpInfo(int employeeId);
	 int insertEmp(EmpVO empVO);
	 int deleteEmp(EmpVO empVO);
	 List<Map<String, Object>> getStat();
	 
}
