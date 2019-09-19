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
}
