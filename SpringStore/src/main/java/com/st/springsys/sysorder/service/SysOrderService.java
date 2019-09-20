package com.st.springsys.sysorder.service;

import java.util.List;

import com.st.springsys.common.vo.PageObject;
import com.st.springsys.sysorder.pojo.SysOrder;

public interface SysOrderService {
	/**
	 * 根据用户查询订单信息
	 * @return
	 */
	SysOrder findOrderByName(String name);
	/**
	 * 最新订单10
	 * @return
	 */
	List<SysOrder> findNewOrder();
	/**
     * 分页查询当前页记录
     * @param name
     * @param pageCurrent
     * @return
     */
	 PageObject<SysOrder> findPageObjects(
			 String name,
			 Integer pageCurrent);
}
