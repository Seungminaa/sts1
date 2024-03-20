package com.example.demo.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class CustomUsers implements UserDetails{

	private UsersVO usersVO;
	
	// usersVO에 대한 생성자사용
	public CustomUsers(UsersVO usersVO) {
		this.usersVO = usersVO;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// usersVO.getGrade()를 GrantedAuthority 형태로 변환해서 넣어줌
		List<SimpleGrantedAuthority> authlist = new ArrayList<SimpleGrantedAuthority>();
		authlist.add(new SimpleGrantedAuthority(usersVO.getGrade()));
		
		return authlist;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usersVO.getUserpw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usersVO.getUserid();
	}
	
	// 로그인시 잠금이나 설정기능
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
