package com.laptrinhjavaweb.dto;

import java.util.Collection;
import java.util.Iterator;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUserDetails extends User {


	private static final long serialVersionUID = 1L;
	public MyUserDetails(String userName,String password,boolean enabled,boolean accountNonExpired,
			boolean credentialsNonExpired,boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(userName,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
		
	}
	private String fullName;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
	
}

	
