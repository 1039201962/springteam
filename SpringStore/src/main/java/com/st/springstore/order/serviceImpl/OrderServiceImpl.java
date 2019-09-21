package com.st.springstore.order.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.car.dao.CarDao;
import com.st.springstore.car.pojo.Car;
import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.OrderVo;
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
	@Override
	public  List<OrderVo> findOrderVos(Integer userId){
		List<OrderVo> list = orderDao.selectInfo(userId);
		return list;
	}
	
	/**
	 * 生成新订单,返回一个订单的id
	 */
	@Override
	public int addOrder(Integer userId,Integer...goodsIds){
		Order order = new Order();
		OrderVo orderVo = null;
		if(goodsIds == null || goodsIds.length==0)
			throw new ServiceException("没有商品可结算");
		long orderId = OrderServiceImpl.orderId();
		List<OrderVo> findOrderVos = findOrderVos(userId);
		for (OrderVo orderVo1 : findOrderVos) {
			if(orderVo1.getStatus()==0) {
				orderVo=orderVo1;
			}
		}
		int Num=0;
		double amount=0.0;
		for (int i = 0; i < goodsIds.length; i++) {
			Integer goodsId = goodsIds[i];
			Goods goods = goodsDao.findGoodsById(goodsId);
			Car car = carDao.findById(userId, goodsId);
			//单个商品的数量
			int num = car.getNum();
			//单个商品的价格
			Double prize = goods.getPrice();
			//累计金额
			amount+=num*prize;
			//累计数量
			Num+=num;
		}		
		initOrderInfo(userId, order, orderVo, orderId, Num, amount);
		System.out.println(order);
		//往数据库写入相应的订单信息
		int i = orderDao.insertOrder(order);
		if(i==0) throw new ServiceException("订单生成异常");
		return order.getId();
	}
	/**
	 * 设置新订单的信息
	 * @param userId
	 * @param order
	 * @param orderVo
	 * @param orderId
	 * @param Num
	 * @param amount
	 */
	private void initOrderInfo(Integer userId, Order order, OrderVo orderVo, long orderId, int Num, double amount) {
		order.setUserId(userId);//设置用户id
		order.setOrder_num(orderId);//设置订单编号
		order.setCreatedTime(new Date());//设置订单生成时间
		order.setPay_status(0);//设置支付状态
		order.setValid(0);//设置订单状态
		order.setAddr(orderVo.getAddr());//设置订单默认收货地址
		order.setMobile(orderVo.getMobile());//设置订单默认收货电话
		order.setName(orderVo.getName());//设置订单收货人姓名
		order.setAmount(amount);//设置订单总金额
		order.setNum(Num); //设置商品的总数量
	}
	/**
	 * 根据订单id查询订单
	 */
	@Override
	public Order findOrder(Integer orderId) {
		Order order = orderDao.findOrder(orderId);
		if(order.getValid()==1)
		throw new ServiceException("订单已经被删除");
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

}
