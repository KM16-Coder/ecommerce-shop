package com.laptrinhjavaweb.api.output;

import java.io.Serializable;

public class JwtResponse implements Serializable{
	private static final long serialVersionUID = -8091879091924046844L;
	private  String jwttoken;
	private String userName;
	private String role;

	public JwtResponse(String userName,String role,String jwttoken) {
		this.userName=userName;
		this.role=role;
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
	
}
