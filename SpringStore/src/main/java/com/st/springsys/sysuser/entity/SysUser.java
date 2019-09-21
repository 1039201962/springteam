package com.st.springsys.sysuser.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysUser implements Serializable{
	private static final long serialVersionUID = 6395624323432452170L;
	private int id;
	private String username;
	//加密处理
	private String password;
	private String salt;//盐值
	private String email;
	private String mobile;
	//是否禁用用户,默认禁用
	private Integer valid=0;
	private Date createdTime;
	private Date modifieTime;
	//支付密码，加密处理
	private String pay_password;
	//支付金额，默认为0
	private Double money=0.0;
	//性别1为男，0为女
	private int sex;
}
