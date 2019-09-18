package com.st.springstore.common.web;


import com.st.springstore.common.vo.JsonResult;

import lombok.extern.slf4j.Slf4j;

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
}
