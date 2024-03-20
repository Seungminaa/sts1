package com.example.demo.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.users.CustomUsers;
import com.example.demo.users.UsersVO;
import com.example.demo.users.mapper.UsersMapper;
import com.example.demo.users.service.UsersService;

import lombok.Setter;


@Service
public class UsersServiceImpl implements UsersService, UserDetailsService{

//	@Setter(onMethod_ = @Autowired)
	@Autowired
	UsersMapper usersMapper;
	
	@Override
	public UsersVO getUsersInfo(String userid) {
		// TODO Auto-generated method stub
		return usersMapper.getUsersInfo(userid);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UsersVO userVO = usersMapper.getUsersInfo(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException("id not found");
		}
		return new CustomUsers(userVO);
	}

}
