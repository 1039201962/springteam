package com.st.order.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.order.dao.OrderDao;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeleteOrderTests {
	@Autowired
	private OrderDao orderDao;
	@Test
	public void delete() {
		int or= orderDao.deleteOrder(2,1);
		System.out.println(or);
	}
}
