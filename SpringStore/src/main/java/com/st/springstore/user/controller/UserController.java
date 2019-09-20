package com.st.springstore.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;
import com.st.springstore.user.service.UserService;
import com.st.springstore.user.serviceImpl.UserServiceImpl;
import com.st.springstore.user.vo.RegisterUser;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(){
		return "shop-checkout";
	}

	@RequestMapping("/regist")
	public String regist(){
		return "shop-checkout";
	}
	
	
	/**登录功能*/
	@RequestMapping("doLogin")
	public JsonResult doLogin(
			String username,
			String password) {
		System.out.println("doLogin(..)");
		
		userService.userDoLogin(username,password);
        
		return new JsonResult("登录ok");
	}
	/**注册功能*/
	@RequestMapping("doRegister")
	public JsonResult doRegister(
			RegisterUser regUser) {
		
		userService.userRegister(regUser);
		return new JsonResult("注册成功！");

	}
	
}
