package com.st.springsys.sysorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.st.springstore.common.vo.JsonResult;
import com.st.springsys.sysorder.service.SysOrderService;

@RestController
public class SysOrderController {
	
	@Autowired
	private SysOrderService sysOrderService;
	
	/**根据用户搜索*/
	@RequestMapping("doFindOrderById")
	public JsonResult doFindOrderById(String name) {
		return new JsonResult(sysOrderService.findOrderByName(name));
	}
	
	/**最新订单显示*/
	@RequestMapping("doFingNewOrder")
	public JsonResult doFingNewOrder(@PathVariable String pages) {
		return new JsonResult(sysOrderService.findNewOrder());
	}
	
	/**分页展示*/
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String name,
			@RequestParam Integer pageCurrent) {
		   return new JsonResult(sysOrderService.findPageObjects(name,pageCurrent));
	}
}

