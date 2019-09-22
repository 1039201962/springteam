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
	public User findUserByUserName(String username) {
		
		return userDao.findUserByUserName(username);
	}
	/**
	 * 通过id查询用户信息
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}
	/**登录功能*/
	@Override
	public int userDoLogin(String username, String password) {
//		//通过用户名去数据库中获取用户信息
//		User sUser = userDao.findUserByUserName(username);
//		String salt = sUser.getSalt();
//		//校验
//		//对传入的密码进行加密
//		SimpleHash sh = 
//		new SimpleHash("MD5", password, salt, 1);
//		//将传入的密码加密和数据库取出的密码对比，判断密码是否一致
//		int status=0;
//		if (!sUser.getPassword().equals(sh.toHex()) ) { 
//			throw new ServiceException("密码不正确！");
//		}else {
//			System.out.println("登录成功！");
//			status=1;//登录成功
//		}
//		return status;
//		
		return 0;
	}
	/**注册新用户*/
	@Override
	public int userRegister(RegisterUser registerUser) {
		//1、校验
		//从数据库中查询注册用户名对应的用户判断是否存在
		User sUser = userDao.findUserByUserName(registerUser.getUsername());
		if(StringUtils.isEmpty(sUser) )
			throw new IllegalArgumentException("用户已存在，请重新输入用户名");
    	if(StringUtils.isEmpty(registerUser.getUsername()))
    		throw new IllegalArgumentException("用户名不能为空！");
    	if(registerUser.getPassword() == null &&"".equals(registerUser.getPassword()))
    		throw new IllegalArgumentException("密码不能为空！");
    	if(!registerUser.getPassword().equals(registerUser.getPasswordConfirm()) )
    		throw new IllegalArgumentException("两次密码不一致！！");
    	if(
    			StringUtils.isEmpty(registerUser.getMobile())||
    			StringUtils.isEmpty(registerUser.getPasswordConfirm())||
    			StringUtils.isEmpty(registerUser.getEmail())||				
    			StringUtils.isEmpty(registerUser.getCity())||
    			StringUtils.isEmpty(registerUser.getCountry())||
    			StringUtils.isEmpty(registerUser.getPostCode())||			
    			StringUtils.isEmpty(registerUser.getRegionState())				
    	)
    		throw new IllegalArgumentException("请填写注册信息，星号（*）部分为必填!");
		//2、保存自身信息
    	//2.1、生成盐值
    	String salt = UUID.randomUUID().toString();
    	//2.2、给密码加密
    	SimpleHash sh = 
    	new SimpleHash("MD5", registerUser.getPassword(), salt, 1);
		//2.3、将注册表中的数据赋予user对象
    	User user=new User();
		user.setUsername(registerUser.getUsername());
		user.setPassword(sh.toHex());
		user.setSalt(salt);
		user.setEmail(registerUser.getEmail());
		user.setMobile(registerUser.getMobile());
		//2.4、保存到数据库中
		userDao.userRegister(user);
		return 1;//1表示注册成功
	}
	
	
}
