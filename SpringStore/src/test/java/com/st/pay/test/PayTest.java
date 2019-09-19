package com.st.pay.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testFindUser() {
		
		String pay_password = userDao.findPayPasswordByUserId(1);
		System.out.println(pay_password);
		
		  User user = userDao.findUserById(1); 
		  System.out.println(user);
		  user.setMobile("18780069752"); 
		  userDao.upDateUser(user);
		  User user1 =userDao.findUserById(1); 
		  System.out.println(user1);
		 
		
		
	}
}
