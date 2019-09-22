package com.st.springstore.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.common.vo.OrderVo;
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
	@ResponseBody
	public JsonResult doAddOrder(Integer userId,Integer...goodsIds) {
		orderService.addOrder(userId,goodsIds);
		return new JsonResult("orderAdd ok");
	}
	/**
	 * 接收订单ID,查询订单
	 * @param orderId
	 * @return
	 */
	@RequestMapping("doFindOrder")
	@ResponseBody
	public JsonResult doFindOrder(Integer userId,Integer orderId) {
		Order order=orderService.findOrder(userId,orderId);
		return new JsonResult(order);
	}
	/**
	 * 接收订单ID,删除订单
	 * @param orders
	 * @return
	 */
	@RequestMapping("doDeleteOrder")
	@ResponseBody
	public JsonResult doDeleteOrder(Integer...orders) {
		System.out.println("doDeleteOrder");
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
	@ResponseBody
	public JsonResult doLikeFindOrder(String goodsName,Integer userId) {
		List<OrderVo> findOrder = orderService.likeFindOrder(goodsName, userId);
		return new JsonResult(findOrder);
	}
	/**
	 * 接收用户id,查询所有订单
	 * @param userId
	 * @return
	 */
	@RequestMapping("doFindAllOrder")
	@ResponseBody
	public JsonResult doFindAllOrder(Integer userId) {
		System.out.println("userId:"+userId);
		System.out.println("doFindAllOrder");
		List<OrderVo> list = orderService.findAllOrder(userId);
		return new JsonResult(list);
	}
	
	@RequestMapping("doFindOrderInfoByOrderId")
	@ResponseBody
	public JsonResult doFindOrderInfoByOrderId(Integer userId,Integer orderId) {
		 Order order = orderService.findOrder(userId,orderId);
		return new JsonResult(order);
	}
	
	/**
	 **取消订单
	 * @param userId
	 * @param orderId
	 * @return
	 */
	@RequestMapping("doCancelOrder")
	@ResponseBody
	public JsonResult doCancelOrder(Integer orderId) {
		orderService.CancelOrder(orderId);
		return new JsonResult("ok");
	}
}
