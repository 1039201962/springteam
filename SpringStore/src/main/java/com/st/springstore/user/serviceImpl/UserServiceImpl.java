package com.st.springstore.user.serviceImpl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;
import com.st.springstore.user.service.UserService;
import com.st.springstore.user.vo.RegisterUser;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	/**
	 * 查询用户
	 */
	public User selectUser(String userName) {
		
		return userDao.selectUser(userName);
	}
	/**
	 * 通过id查询用户信息
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**登录功能*/
	@Override
	public int userDoLogin(String username, String password) {
		//获取用户信息
		User sUser = selectUser(username);
		String salt = sUser.getSalt();
		//校验
		//对传入的密码进行加密
		SimpleHash sh = 
		new SimpleHash("MD5", password, salt, 1);
		if (sUser.getPassword() != sh.toHex()) {
			throw new ServiceException("密码不正确！");
		}else {
			System.out.println("登录成功！");
			return 1;//登录成功
//			return 0;
		}
		
		
	}
	/**注册新用户*/
	@Override
	public int userRegister(RegisterUser regUser) {
		//1、校验
		//判断用户是否已存在
		if(regUser.getUsername() != null)
			throw new ServiceException("用户已存在，请重新输入用户名");
		if(regUser.getUsername() == null || 
				regUser.getMobile()==null||
				regUser.getEmail()==null||
				regUser.getPassword()==null||
				regUser.getPasswordConfirm()==null||
				regUser.getCity()==null||
				regUser.getCountry()==null||
				regUser.getPostCode()==null||
				regUser.getRegionState()==null				
				)
    		throw new ServiceException("请填写注册信息，星号（*）部分为必填");
    	if(StringUtils.isEmpty(regUser.getUsername()))
    		throw new ServiceException("用户名不能为空");
    	if(regUser.getPassword() == null)
    		throw new ServiceException("密码不能为空");
    	if(regUser.getPassword() != regUser.getPasswordConfirm())
    		throw new ServiceException("两次密码不一致");
		//2、保存自身信息
    	//2.1、获取盐值
    	String salt = UUID.randomUUID().toString();
    	//2.2、给密码加密
    	SimpleHash sh = 
    	new SimpleHash("MD5", regUser.getPassword(), salt, 1);
    	regUser.setPassword(sh.toHex());
		User user=new User();
		user.setUsername(regUser.getUsername());
		user.setPassword(sh.toHex());
		user.setSalt(salt);
		user.setMobile(regUser.getMobile());
		userDao.userRegister(user);
		return 1;//1表示注册成功
	}
	
	
}
