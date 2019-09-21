package com.st.springstore.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;
import com.st.springstore.user.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	/**
	 * 查询用户
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**登录功能*/
	@Override
	public int userDoLogin(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**注册新用户*/
	@Override
	public int userRegister(User user) {
		//1、校验
		if(user==null)
    		throw new ServiceException("请填写注册信息");
    	if(StringUtils.isEmpty(user.getUsername()))
    		throw new ServiceException("用户名不能为空");
    	if(user.getPassword() == null)
    		throw new ServiceException("密码不能为空");
		//2、保存自身信息
    	//2.1、给密码加盐值
		userDao.userRegister(user);
		return 0;
	}
}
