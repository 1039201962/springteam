package com.st.springstore.pay.serviceImpl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.order.pojo.Order;
import com.st.springstore.pay.service.PayService;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;

@Service
public class PayServiceImpl implements PayService {
//	@Autowired
//	private UserDao userDao;

	@Override
	public void doPay(Order order, String password) {
		int userId = order.getUserId();
		//User user = userDao.findUserById();
		User user = new User();
		SimpleHash sh=new SimpleHash("MD5",password, user.getSalt(), 1);
		String pwd = sh.toHex();
		if(pwd.equals(user.getPassword())) {
			if(user.getMoney()>=order.getAmount()) {
				
			}
			
		}
		/**
		 * SimpleHash sh=new SimpleHash("MD5",
        		password, user.getSalt(), 1);
        String pwd=sh.toHex();
        if(!pwd.equals(user.getPassword()))
		 */

	}

}
