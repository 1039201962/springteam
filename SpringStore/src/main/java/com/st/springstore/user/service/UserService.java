package com.st.springstore.user.service;

import com.st.springstore.user.pojo.User;
import com.st.springstore.user.vo.RegisterUser;

public interface UserService {
	/** 用户登录 */
	int userDoLogin(String username,String password);
	/** 用户注册  */
	int userRegister(RegisterUser regUser);
	/** 根据id查询用户 ，由于个人信息的查询（使用vo封装部分信息返回）*/
	User findUserById(int id);
	

}
