package com.st.springstore.user.vo;

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
	private String addr1;
	private String addr2;
	private String city;
	private String postCode;
	private String country;
	private String regionState;
	public RegisterUser() {
		super();
	}
	public RegisterUser(String username, String email, String mobile, String password, String passwordConfirm,
			String addr1, String addr2, String city, String postCode, String country, String regionState) {
		super();
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		this.regionState = regionState;
	}
		
	
}
