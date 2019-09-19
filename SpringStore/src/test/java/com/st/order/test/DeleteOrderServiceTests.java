package com.st.order.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteOrderServiceTests {
	@Autowired
	private OrderService orderService;
	@Test
	public void orderService() {
		int deleteOrder = orderService.deleteOrder(1);
		System.err.println(deleteOrder);
	}
}
