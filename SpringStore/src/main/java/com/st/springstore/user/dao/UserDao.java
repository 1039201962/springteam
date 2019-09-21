package com.st.springstore.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.st.springstore.user.pojo.User;

@Mapper
public interface UserDao {
	/**
	 *  注册新用户
	 * @param user
	 * @return
	 */
	int userRegister(User user);
	/**
	 * 根据用id查找用户
	 * @param username
	 * @return
	 */
	User findUserById(int id);
	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过用户id查询支付密码
	 * @param id
	 * @return
	 */
	String findPayPasswordByUserId(int id);
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	User findUserByUserName(String username);
	
}
