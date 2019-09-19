package com.st.order.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.order.dao.OrderDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderVoTests {
	@Autowired
	private OrderDao orderDao;
	@Test
	public void orderVo() {
		List<OrderVo> list = orderDao.selectInfo(1);
		for (OrderVo orderVo : list) {
			System.out.println(orderVo);
		}
	}
}
