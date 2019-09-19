package com.st.springstore.order.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.order.pojo.Order;

@Mapper
public interface OrderDao {
<<<<<<< HEAD
	/**
	 * 将order对象写入数据库
	 * @param zyj
	 */
	 int insertOrder(Order order);
	 
	 List<OrderVo> selectInfo(Integer userId);
=======

	

>>>>>>> branch 'project' of https://github.com/1039201962/springteam.git
}
