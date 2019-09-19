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
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findUserByUserName(String username);
}
