package com.st.springstore.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.goods.pojo.Goods;
import com.st.springstore.order.pojo.Order;
import com.st.springstore.order.service.OrderService;
import com.st.springstore.user.pojo.User;

@Controller
@RequestMapping("/orders/")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping("doAddOrder")
	public String doAddOrder(Integer userId,Integer...goodsIds) {
		orderService.addOrder(userId,goodsIds);
		return "shop-wishlist";
	}
	@RequestMapping("doFindOrder")
	public JsonResult doFindOrder(Integer orderId) {
		Order order=orderService.findOrder(orderId);
		return new JsonResult(order);
	}
	@RequestMapping("doDeleteOrder")
	public JsonResult doDeleteOrder(Integer...orders) {
		int deleteOrder= orderService.deleteOrder(orders);
		return new JsonResult("delete ok");
	}
}
