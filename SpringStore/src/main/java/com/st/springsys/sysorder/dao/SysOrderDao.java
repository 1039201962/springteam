package com.st.springsys.sysorder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.st.springsys.sysorder.pojo.SysOrder;

@Mapper
public interface SysOrderDao {
	/**
	 * 根据用户名查询订单详细信息
	 * @return
	 */
	SysOrder findOrderByName(String name);
	/**
	 * 最新订单10
	 * @return
	 */
	List<SysOrder> findNewOrder();
	/**
	  * 依据条件查询日志记录总数
	  * @param name 查询条件
	  * @return 查询到记录总数
	  */
	 int getRowCount(@Param("name")String name);
	 
	 /**
	  * 分页查询当前页日志信息
	  * @param name 查询条件
	  * @param startIndex 当前页起始位置
	  * @param pageSize 当前页面大小
	  * @return 当前页查询到记录
	  */
	 List<SysOrder> findPageObjects(
			      @Param("name")String name,
			      @Param("pageIndex")Integer pageIndex,
			      @Param("pageSize")Integer pageSize);
}
