package com.st.springstore.order.service;

import java.util.List;

import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.common.vo.ReceivingVo;
import com.st.springstore.order.pojo.Order;

public interface OrderService {
	/**
	 * 新增订单
	 * @param order
	 * @return addOrder
	 */
	int addOrder (Integer userId,Integer...goodsIds);
	
	/**
	 * 通过订单id查询订单
	 * @param orderId
	 * @return
	 */
	Order findOrder(Integer userId,Integer orderId);
	/**
	 * 通过订单id删除订单
	 * @param orderIds
	 * @return
	 */
	int deleteOrder(Integer...orderIds);
	/**
	 * 通过商品名,用户id,模糊查询订单
	 * @param goodsName
	 * @param userId
	 * @return
	 */
	List<OrderVo> likeFindOrder(String goodsName,Integer userId);
	/**
	 * 通过用户id查询所有订单
	 * @param userId
	 * @return
	 */
	List<OrderVo> findAllOrder(Integer userId);
	
	
}
