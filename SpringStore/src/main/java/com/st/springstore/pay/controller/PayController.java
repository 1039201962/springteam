package com.st.springstore.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.order.pojo.Order;
import com.st.springstore.pay.service.PayService;

@Controller
@RequestMapping("/pay/")
public class PayController {
	@Autowired
	private PayService  payService;

	@RequestMapping("toPayPage")
	public void toPayPage(Order order,Model model) {
		
	}
	
	@RequestMapping("doPay")
	@ResponseBody
	public JsonResult doPay(Integer orderId,String password) {
		System.out.println(orderId);
		System.out.println(password);
		payService.doPay(orderId,password);
		return new JsonResult("ok");
	}

}
