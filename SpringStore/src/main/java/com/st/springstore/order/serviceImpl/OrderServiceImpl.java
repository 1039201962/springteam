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
	/**
	 * 生成随机的订单编号
	 * @return
	 */
	public static Integer  orderId() {
	        int r1 = (int) (Math.random() * (9) + 1);//产生2个0-9的随机数
	        int r2 = (int) (Math.random() * (10));
	        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss");
	        String format = yyyyMMddHHmmss.format(new Date());
	        return Integer.parseInt(format + r1+r2);
	    }
	/**
	 * 查询用户的默认收货地址信息
	 * @param userId
	 * @return
	 */
	public OrderVo findOrderVo(Integer userId) {
		List<OrderVo> list = orderDao.selectInfo(userId);
		OrderVo orderVo = null;
		for (OrderVo orderVo1 : list) {
			if(orderVo1.getStatus()==0) {
				orderVo=orderVo1;
			}
		}
		return orderVo;
	}
	/**
	 *查询用户的所有收货地址
	 */
	@Override
	public  List<OrderVo> findOrderVos(Integer userId){
		List<OrderVo> list = orderDao.selectInfo(userId);
		return list;
	}
	
	
	@Override
	public int addOrder(Integer userId,Integer...goodsIds){
		Order order = new Order();
		if(goodsIds.length==0)
		throw new ServiceException("没有商品数据");
		int orderId = OrderServiceImpl.orderId();
		
		order.setUserId(userId);//设置用户id
		order.setOrder_num(orderId);//设置订单编号
		order.setCreatedTime(new Date());//设置订单数量
		order.setPay_status(0);//设置支付状态
		order.setValid(0);//设置订单状态
		return 0;
	}
	
}
