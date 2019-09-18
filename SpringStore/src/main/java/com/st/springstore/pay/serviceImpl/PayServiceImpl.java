package com.st.springstore.pay.serviceImpl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.order.pojo.Order;
import com.st.springstore.pay.service.PayService;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;

@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private UserDao userDao;

	@Override
	public void doPay(Order order, String payPassword) {
		int userId = order.getUserId();
		//User user = userDao.findUserById();
		User user = new User();
		SimpleHash sh=new SimpleHash("MD5",payPassword, user.getSalt(), 1);
		String pwd = sh.toHex();
		if(!pwd.equals(user.getPay_password())) throw new ServiceException("支付密码错误");
		Double userMoney = user.getMoney();
		Double spendMoney = order.getAmount();
		if(spendMoney>userMoney) throw new ServiceException("账户余额不足");
		user.setMoney(userMoney-spendMoney);
		//userdao.updateUserById();
	}
}
