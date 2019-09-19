package com.st.springstore.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;
import com.st.springstore.user.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserServiceImpl userServiceImp;

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/regist")
	public String regist(){
		return "regist";
	}
	
	
	/**登录功能*/
	@RequestMapping("doLogin")
	public JsonResult doLogin(
			String username,
			String password,
			boolean isRememberMe) {
//		System.out.println("doLogin(..)");
//		//1.封装用户信息
//		UsernamePasswordToken token=new UsernamePasswordToken();
//		token.setUsername(username);
//		token.setPassword(password.toCharArray());
//		//2.提交用户信息(借助Subject对象)
//		//获取Subject对象
//		Subject subject=SecurityUtils.getSubject();
//		//是否记住用户密码
//		if(isRememberMe)token.setRememberMe(true);
//		//提交用户信息进行认证
//		subject.login(token);
		
		return new JsonResult("登录ok");
	}
	/**注册功能*/
	@RequestMapping("doRegister")
	public JsonResult doRegister(
			User user) {
		
		userServiceImp.userRegister(user);
		return new JsonResult("注册成功！");

	}
	
}
