package com.st.springstore.order.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.order.pojo.Order;

@Mapper
public interface OrderDao {
	/**
	 * 将order对象写入数据库
	 * @param zyj
	 */
	int insertOrder(Order order);
	/**
	 * 查询收货信息
	 * @param zyj
	 */
	List<OrderVo> selectInfo(Integer userId);
	/**
	 * 根据订单id查询订单
	 * @param orderId
	 * @return
	 */
	Order findOrder(Integer orderId);
	/**
	 * 根据订单id删除订单
	 * @param orderIds
	 * @return
	 */
	int deleteOrder(Integer...orderIds);
}
