package com.st.order.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.order.service.OrderService;
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
	@Autowired
	private OrderService orderService;
	@Test
	public void testOrderService() {
		orderService.addOrder(1, 1);
	}
	
}
