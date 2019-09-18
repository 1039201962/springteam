package com.st.springstore.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.springstore.order.pojo.Order;
import com.st.springstore.pay.service.PayService;

@Controller
public class PayController {
	@Autowired
	private PayService  payService;

	@RequestMapping("toPayPage")
	public void toPayPage(Order order,Model model) {
		
	}
	
	@RequestMapping("doPay")
	public void doPay(Order order,String password) {
		payService.doPay(order,password);
	}

}
