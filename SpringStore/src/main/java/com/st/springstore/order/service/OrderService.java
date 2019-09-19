package com.st.springstore.order.service;

<<<<<<< HEAD
import java.util.List;
=======

public interface OrderService {

	
>>>>>>> branch 'project' of https://github.com/1039201962/springteam.git

import com.st.springstore.common.vo.OrderVo;

public interface OrderService {
	/**
	 * 新增订单
	 * @param order
	 * @return addOrder
	 */
	int addOrder (Integer userId,Integer...goodsIds);
	/**
	 * 查询收货信息
	 * @param userId
	 * @return
	 */
	List<OrderVo> findOrderVo(Integer userId);
}
