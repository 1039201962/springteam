package com.st.springstore.pay.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
	/* 结算 */
	int doPay(Integer userId,double money);

	int doPayOrder(Integer orderId);

}
