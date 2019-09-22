package com.st.springstore.pay.serviceImpl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.order.dao.OrderDao;
import com.st.springstore.order.pojo.Order;
import com.st.springstore.pay.dao.PayDao;
import com.st.springstore.pay.service.PayService;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;

@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao; 
	@Autowired
	private PayDao payDao;


	@Override
	public void doPay(Integer orderId, String payPassword) {
		Order order = orderDao.findOrder(orderId);
		//1.参数校验
		if(order==null) 
			throw new IllegalArgumentException("订单信息异常");
		if(order.getValid()==1) 
			throw new ServiceException("订单无效");
		if(payPassword==null || !(payPassword.length()==6)) 
			throw new IllegalArgumentException("密码参数不合法");
		int userId = order.getUserId();
		User user = userDao.findUserById(userId);
		String password = userDao.findPayPasswordByUserId(userId);		
		SimpleHash sh=new SimpleHash("MD5",payPassword, user.getSalt(), 1);
		String pwd = sh.toHex();
		System.out.println("pwd:"+pwd);
		System.out.println("password:"+password);
		if(!pwd.equals(password)) throw new ServiceException("支付密码错误");
		Double userMoney = user.getMoney();
		Double spendMoney = order.getAmount();
		if(spendMoney>userMoney) throw new ServiceException("账户余额不足");
		int rows = payDao.doPay(userId, spendMoney);
		if(rows==0) throw new ServiceException("结算失败");
		int i = payDao.doPayOrder(orderId);
		if(i==0) throw new ServiceException("结算失败");
		System.out.println("结算完成");
	}
}
