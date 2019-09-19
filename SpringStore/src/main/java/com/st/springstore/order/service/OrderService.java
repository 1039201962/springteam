package com.st.springstore.order.service;

import java.util.List;

import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.order.pojo.Order;

public interface OrderService {
	/**
	 * 新增订单
	 * @param order
	 * @return addOrder
	 */
	int addOrder (Integer userId,Integer...goodsIds);
	/**
	 * 通过userId查询收货信息
	 * @param userId
	 * @return
	 */
	List<OrderVo> findOrderVos(Integer userId);
	/**
	 * 通过订单id查询订单
	 * @param orderId
	 * @return
	 */
	Order findOrder(Integer orderId);
	/**
	 * 通过订单id删除订单
	 * @param orderIds
	 * @return
	 */
	int deleteOrder(Integer...orderIds);
}
