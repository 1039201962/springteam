package com.st.springstore.order.service;

import java.util.List;

import com.st.springstore.common.vo.OrderVo;

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
	
}
