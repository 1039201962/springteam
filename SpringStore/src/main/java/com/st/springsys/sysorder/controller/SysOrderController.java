package com.st.springsys.sysorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.st.springstore.common.vo.JsonResult;
import com.st.springsys.sysorder.pojo.SysOrder;
import com.st.springsys.sysorder.service.SysOrderService;

@RestController
@RequestMapping("/sysorder/")
public class SysOrderController {
	
	@Autowired
	private SysOrderService sysOrderService;
	
	/**修改订单*/
	 @RequestMapping("doUpdateSysOrder")
	 public JsonResult doUpdateSysOrder(SysOrder sysOrder) {
		 sysOrderService.updateSysOrder(sysOrder);
		 return new JsonResult("update ok");
	 }
	
	/**删除订单*/
	@RequestMapping("doDeleteSysOrder")
	public JsonResult doDeleteSysOrder(Integer...orders) {
		sysOrderService.deleteSysOrder(orders);
		return new JsonResult("delete ok");
	}
	
	/**根据用户搜索*/
	@RequestMapping("doFindOrderByName")
	public JsonResult doFindOrderByName(String name) {
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

