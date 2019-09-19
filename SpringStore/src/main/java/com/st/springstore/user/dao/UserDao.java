package com.st.springstore.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.st.springstore.user.pojo.User;

@Mapper

public interface UserDao {
	/**
	 * 保存用户自身信息
	 * @param user
	 * @return
	 */
	int registerObject(User user);
	/**
	 * 根据用户的id查询用户，返回一个用户实体
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
	
	int upDateUser(User user);
	
	String findPayPasswordByUserId(int userId);
}
