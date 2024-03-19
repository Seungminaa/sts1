package com.example.demo.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.searchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

import lombok.Setter;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Setter(onMethod_ = @Autowired ) //@Autowired
	EmpMapper empMapper;
	
	@Override
	public Map<String, Object> getEmpList(EmpVO vo, searchVO svo) {
		Map<String,Object> map = new HashMap<String, Object>();
		// 리스트와 전체건수
		map.put("data", empMapper.getEmpList(vo, svo));
		map.put("count", empMapper.getCount(vo, svo));
		
		return map;
	}

	@Override
	public EmpVO getEmpInfo(int employeeId) {
		// TODO Auto-generated method stub
		return empMapper.getEmpInfo(employeeId);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.insertEmp(empVO);
	}

	@Override
	public int deleteEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.deleteEmp(empVO);
	}

	@Override
	public List<Map<String, Object>> getStat() {
		// TODO Auto-generated method stub
		return empMapper.getStat();
	}

}
