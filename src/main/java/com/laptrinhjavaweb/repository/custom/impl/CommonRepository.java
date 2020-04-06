package com.laptrinhjavaweb.repository.custom.impl;

public class CommonRepository {
	public StringBuilder createSQLfindInfor() {
		return new StringBuilder("SELECT username,address,district,email,fullname,gender,phonenumber FROM user");
		
			
	}
	public StringBuilder createSQLLogin() {
		
		return new StringBuilder("SELECT username,password FROM user");
	}
	public StringBuilder createSQLRole() {
		
		return new StringBuilder("SELECT code FROM role r INNER JOIN user_role us ON r.id=us.role_id ");
	}
}
