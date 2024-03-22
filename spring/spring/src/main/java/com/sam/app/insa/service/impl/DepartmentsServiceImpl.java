package com.sam.app.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.app.insa.mapper.DepartmentsMapper;
import com.sam.app.insa.service.DepartmentService;
import com.sam.app.insa.service.DepartmentsVO;

@Service
public class DepartmentsServiceImpl implements DepartmentService{

	@Autowired DepartmentsMapper departmentsMapper;
	
	@Override
	public List<DepartmentsVO> getList() {
		// TODO Auto-generated method stub
		return departmentsMapper.getList();
	}
	
}
