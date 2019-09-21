package com.st.springsys.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.st.springsys.sysuser.entity.SysUser;
import com.st.springsys.sysuser.pojo.SysUserPojo;

@Mapper
public interface SysUserDao {
//  根据用户id删除用户
	int delectObject(Integer id);
//	根据用户id查询当前用户信息
	SysUserPojo findObjectById(Integer id);	
//	保存用户自身信息
	int insertObject(SysUser entity);
//	更新用户自身信息
	int updateObject(SysUser entity);
//	禁用和启用
	int validById(@Param("id")Integer id,
			@Param("valid")Integer valid);
//	基于用户名统计记录用户总数
	int getRowCount(@Param("username")String username);
	/**
	 *分页查询所有用户信息
	 * @param username 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
List<SysUserPojo> findPageObjects( 
		@Param("username")String username,
		@Param("startIndex")Integer startIndex,
		@Param("pageSize")Integer pageSize);
}
