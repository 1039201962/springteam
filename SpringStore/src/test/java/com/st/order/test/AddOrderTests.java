package com.st.order.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.car.dao.CarDao;
import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.goods.dao.GoodsDao;
import com.st.springstore.order.dao.OrderDao;
import com.st.springstore.order.service.OrderService;
import com.st.springstore.user.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddOrderTests {
	
	@Autowired
	private GoodsDao goodDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CarDao carDao;
	@Test
	public void addOrdertest() {
		
		int i = orderService.addOrder(1,1002,1003);
	}
	@Test
	public void TestFindOrderByUserId() {
		List<OrderVo> OrderVos = orderDao.findOrderByUserId(1);
		for (Iterator iterator = OrderVos.iterator(); iterator.hasNext();) {
			OrderVo orderVo = (OrderVo) iterator.next();
			System.out.println(orderVo);
		}
		
	}
}
