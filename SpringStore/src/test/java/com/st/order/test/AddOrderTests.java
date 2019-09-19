package com.st.order.test;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.st.springstore.order.dao.OrderDao;
import com.st.springstore.order.pojo.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddOrderTests {
	@Autowired
	private OrderDao orderDao;
	@Test
	public void addOrdertest() {
<<<<<<< HEAD
		Order order=new Order();
=======
		Order order = new Order();
>>>>>>> branch 'project' of https://github.com/1039201962/springteam.git
		order.setUserId(1);
		order.setCreatedTime(new Date());
		order.setAddr("成都");
		order.setOrder_num(151456456);
		order.setGoodsId(2);
		order.setNum(2);
		order.setPay_status(0);
		order.setAmount(555.0);
		order.setValid(0);
		order.setMobile("1008611");
		order.setName("1");
		int insertOrder = orderDao.insertOrder(order);
		System.out.println(insertOrder);
	}
}
