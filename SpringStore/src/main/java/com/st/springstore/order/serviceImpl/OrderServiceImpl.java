package com.st.springstore.order.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.car.pojo.Car;
import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.goods.pojo.Goods;
import com.st.springstore.order.dao.OrderDao;
import com.st.springstore.order.pojo.Order;
import com.st.springstore.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	public static Integer  orderId() {
	        int r1 = (int) (Math.random() * (9) + 1);//产生2个0-9的随机数
	        int r2 = (int) (Math.random() * (10));
	        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss");
	        String format = yyyyMMddHHmmss.format(new Date());
	        return Integer.parseInt(format + r1+r2);
	    }
	@Override
	public int addOrder(Integer userId,Integer...goodsIds){
		if(goodsIds.length==0)
		throw new ServiceException("没有商品数据");
		int orderId = OrderServiceImpl.orderId();
		Order order = new Order();
		order.setUserId(userId);//设置用户id
		order.setOrder_num(orderId);//设置订单编号
		order.setCreateTime(new Date());//设置订单数量
		order.setPay_status(0);//设置支付状态
		order.setValid(0);//设置订单状态
		return 0;
	}
	@Override
	public List<OrderVo> findOrderVo(Integer userId) {
		List<OrderVo> orderVo = orderDao.selectInfo(userId);
		return orderVo;
	}
	
}
