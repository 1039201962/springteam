package com.st.springstore.user.vo;

import java.util.HashMap;

import lombok.Data;
/**
 * 封装网页上的注册信息
 * @author lenovo
 *
 */
@Data
public class RegisterUser {
	private String username;
	private String email;
	private String mobile;
	private String password;
	private String passwordConfirm;
	private HashMap<String,String> addrs;
	private String name;
	private int status;
	public RegisterUser() {
		super();
	}
	public RegisterUser(String username, String email, String mobile, String password, String passwordConfirm,
			HashMap<String, String> addrs, String name, int status) {
		super();
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.addrs = addrs;
		this.name = name;
		this.status = status;
	}
	
	
	
	
}
