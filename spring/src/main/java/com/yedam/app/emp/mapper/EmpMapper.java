package com.yedam.app.emp.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	//mapper의 namespace와 경로가 동일하게 하면 mapper사용가능
	@Select("select sysdate from dual")
	public String getTime();
	
	public Map<String, Object> getInfo(String employeeId);
	
}
