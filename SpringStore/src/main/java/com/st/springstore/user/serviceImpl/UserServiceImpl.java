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
		//校验
		if(user==null)
    		throw new ServiceException("保存对象不能为空");
    	if(StringUtils.isEmpty(user.getUsername()))
    		throw new ServiceException("用户名不能为空");
    	if(user.getPassword() != passwordConfirm)
    		throw new ServiceException("密码不能为空");
		//保存自身信息
		userDao.userRegister(user);
		return 0;
	}
}
