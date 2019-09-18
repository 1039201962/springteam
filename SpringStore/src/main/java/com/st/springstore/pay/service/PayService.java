package com.st.springstore.pay.service;

import com.st.springstore.order.pojo.Order;

public interface PayService {

	void doPay(Order order, String password);

}
