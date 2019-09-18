package com.st.springstore.order.service;

import com.st.springstore.order.pojo.Order;

public interface OrderService {

	void doPay(Order order, String password);

}
