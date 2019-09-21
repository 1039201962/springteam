package com.st.springsys.sysuser.service;

import java.util.Map;

import com.st.springstore.common.vo.PageObject;
import com.st.springsys.sysuser.entity.SysUser;
import com.st.springsys.sysuser.pojo.SysUserPojo;

public interface SysUserService {
//  根据id删除用户
	int deleteObject(Integer id);
//	基于用户ID查询用户信息	
	Map<String, Object> findObjectById(Integer id);

//	保存用户数据
	int saveObject(SysUser entity); 
//	更新保存用户数据
	int updateObject(SysUser entity); 
//	禁用和启用
	int validById(Integer id,Integer valid);
//	分页查询用户信息
    PageObject<SysUserPojo> findPageObjects(
		String username,
		Integer pageCurrent);

}
 