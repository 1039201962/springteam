package com.st.springstore.order.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.car.dao.CarDao;
import com.st.springstore.car.pojo.Car;
import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.common.vo.OrderVo;
import com.st.springstore.common.vo.ReceivingVo;
import com.st.springstore.goods.dao.GoodsDao;
import com.st.springstore.goods.pojo.Goods;
import com.st.springstore.goods.serviceImpl.GoodsServiceImpl;
import com.st.springstore.order.dao.OrderDao;
import com.st.springstore.order.pojo.Order;
import com.st.springstore.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CarDao carDao;
	@Autowired
	private GoodsDao goodsDao;
	/**
	 * 该方法用于生成订单编号
	 * @return
	 */
	public static Long  orderId() {
		int r1 = (int) (Math.random() * (9) + 1);//产生2个0-9的随机数
		SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = yyyyMMddHHmmss.format(new Date());
		return Long.parseLong(format + r1);

	}
	/**
	 *查询用户的所有收货地址
	 */
	
	public   List<ReceivingVo> findreceivingInfos(Integer userId){
		List<ReceivingVo> list = orderDao.selectInfo(userId);
		return list;
	}
	
	/**
	 * 生成新订单,返回一个订单的id
	 */
	@Override
	public int addOrder(Integer userId,Integer...goodsIds){	
		//生成新订单
		Order order = new Order();
		//生成订单编号
		long orderId = OrderServiceImpl.orderId();
		//收货信息
		ReceivingVo receivingInfo = null;
		//判断是否有商品可结算
		if(goodsIds.length==0)
			throw new ServiceException("没有商品可结算");
		//查询用户收货信息
		List<ReceivingVo> findreceivingInfos = findreceivingInfos(userId);
		//查询默认收货地址
		for (ReceivingVo receivingInfo1 : findreceivingInfos) {
			if(receivingInfo1.getStatus()==0) {
				receivingInfo=receivingInfo1;
			}
		}
		
		order.setUserId(userId);
		order.setOrder_num(orderId);
		order.setCreatedTime(new Date());
		order.setAddr(receivingInfo.getAddr());
		order.setName(receivingInfo.getName());
		order.setMobile(receivingInfo.getMobile());
		//总金额
		double amount=0.0;
		for (int i = 0; i < goodsIds.length; i++) {		
			Integer goodsId = goodsIds[i];
			//查找商品
			Goods goods = goodsDao.findGoodsById(goodsId);
			Car car = carDao.findById(userId, goodsId);
			//单个商品的数量
			int num = car.getNum();
			//单个商品的价格
			Double prize = goods.getPrice();
			//累计金额
			amount+=num*prize;	
		}
		for (int i = 0; i < goodsIds.length; i++) {
			Integer goodsId = goodsIds[i];
			Car car = carDao.findById(userId, goodsId);
			//单个商品的数量
			int num = car.getNum();
			order.setAmount(amount);
			order.setGoodsId(goodsId);
			order.setNum(num);
			orderDao.insertOrder(order);			
		}
		//从购物车移除对应的信息
		carDao.delectCarByGoodsId(userId, goodsIds);
		return 0;
		
	}
	
	/**
	 * 根据订单id查询订单
	 */
	@Override
	public Order findOrder(Integer userId,Integer orderId) {
		Order order = orderDao.findOrder(orderId);
		return order;			
	}
	/**
	 * 根据订单id删除订单
	 */
	@Override
	public int deleteOrder(Integer... orderIds) {
		int rows = orderDao.deleteOrder(orderIds);
		return rows;
	}
	/**
	 * 根据商品名模糊查询订单
	 */
	@Override
	public List<Order> likeFindOrder(String goodsName, Integer userId) {
		List<Order> listOrder = orderDao.likeFindOrder(goodsName, userId);
		return listOrder;
	}		
	/**
	 * 根据用户id查询所有订单
	 */
	@Override
	public List<OrderVo> findAllOrder(Integer userId) {
		if(userId==null) throw new ServiceException("没有对应的用户信息");
		List<OrderVo> orderVos = orderDao.findOrderByUserId(userId);
		if(orderVos==null) throw new  ServiceException("没有对应订单信息");
		return orderVos; 
	}


}
