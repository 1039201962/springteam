package com.st.springstore.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
		//1.获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		//2.通过Subject提交用户信息,交给shiro框架进行认证操作
		//2.1对用户进行封装
		UsernamePasswordToken token = 
				new UsernamePasswordToken(
						username,password);
		//2.2对用户信息进行身份认证
		subject.login(token);
        
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
