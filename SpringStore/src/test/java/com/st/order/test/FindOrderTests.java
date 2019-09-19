package com.st.order.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.order.dao.OrderDao;
import com.st.springstore.order.pojo.Order;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FindOrderTests {
	@Autowired
	private OrderDao orderDao;
	@Test
	public void findOrder() {
		 Order order = orderDao.findOrder(1);
		 System.out.println(order);
	}
	@Test
	public void findLikeOrder() {
		List<Order> likeF = orderDao.likeFindOrder("1", 1);
		for (Iterator iterator = likeF.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			System.out.println(order);
		}
	}
}
