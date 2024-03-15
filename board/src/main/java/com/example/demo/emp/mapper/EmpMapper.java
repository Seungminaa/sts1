package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.searchVO;

@Mapper
public interface EmpMapper {

	 List<EmpVO> getEmpList(@Param("vo") EmpVO vo,@Param("svo") searchVO svo);
	 EmpVO getEmpInfo(int employeeId);
	 int insertEmp(EmpVO empVO);
	 int deleteEmp(EmpVO empVO);
	 List<Map<String, Object>> getStat();
	 int updateEmp(EmpVO empVO);
}
