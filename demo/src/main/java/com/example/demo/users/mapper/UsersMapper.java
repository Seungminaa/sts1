package com.example.demo.users.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.users.UsersVO;

@Mapper
public interface UsersMapper {

	 UsersVO getUsersInfo(String userid);
//	 List<UsersVO> getUserList(UsersVO vo);
//	 int insertUser(UsersVO vo);
//	 int deleteUser(UsersVO vo);
	
}
