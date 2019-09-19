package com.st.springstore.order.controller;

import java.util.List;

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
	/**
	 * 接收用户id 多个商品id生成新订单
	 * @param userId
	 * @param goodsIds
	 * @return
	 */
	@RequestMapping("doAddOrder")
	public String doAddOrder(Integer userId,Integer...goodsIds) {
		orderService.addOrder(userId,goodsIds);
		return "shop-wishlist";
	}
	/**
	 * 接收订单ID,查询订单
	 * @param orderId
	 * @return
	 */
	@RequestMapping("doFindOrder")
	public JsonResult doFindOrder(Integer orderId) {
		Order order=orderService.findOrder(orderId);
		return new JsonResult(order);
	}
	/**
	 * 接收订单ID,删除订单
	 * @param orders
	 * @return
	 */
	@RequestMapping("doDeleteOrder")
	public JsonResult doDeleteOrder(Integer...orders) {
		int deleteOrder= orderService.deleteOrder(orders);
		return new JsonResult("delete ok");
	}
	/**
	 * 接受商品名,用户id,模糊查询订单
	 * @param goodsName
	 * @param userId
	 * @return
	 */
	@RequestMapping("doLikeFindOrder")
	public JsonResult doLikeFindOrder(String goodsName,Integer userId) {
		List<Order> findOrder = orderService.likeFindOrder(goodsName, userId);
		return new JsonResult(findOrder);
	}
}
