package com.st.springstore.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.springstore.order.pojo.Order;
import com.st.springstore.order.service.OrderService;

@Controller
public class PayController {
	@Autowired
	private OrderService  orderService;

	@RequestMapping("toPayPage")
	public void toPayPage(Order order,Model model) {
		
	}
	
	@RequestMapping("doPay")
	public void doPay(Order order,String password) {
		orderService.doPay(order,password);
	}

}
