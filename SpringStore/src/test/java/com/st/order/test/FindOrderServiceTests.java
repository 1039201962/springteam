package com.st.order.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.order.pojo.Order;
import com.st.springstore.order.service.OrderService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FindOrderServiceTests {
	@Autowired
	private OrderService orderService;
	@Test
	public void findService() {
		Order findOrder = orderService.findOrder(1);
		System.out.println(findOrder);
	}
}
