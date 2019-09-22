package com.st.springstore.common.web;


import com.st.springstore.common.vo.JsonResult;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e) {
		log.error(e.getMessage());
		e.printStackTrace();

		return new JsonResult(e);
	}
	/**shiro安全框架全局异常处理*/
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	private JsonResult doHandleShiroException(
			ShiroException e) {
		
		JsonResult jr = new JsonResult();
		jr.setState(0);
		if (e instanceof UnknownAccountException) {
			jr.setMessage("账号不存在！");
		}else if(e instanceof IncorrectCredentialsException){
			jr.setMessage("密码不正确！");
		}else if(e instanceof AuthorizationException){
			jr.setMessage("没有此操作权限！");
		}else {
			jr.setMessage("系统维护中！");
		}
		return jr;

	}
}
