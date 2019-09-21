package com.st.springsys.sysuser.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.PageObject;
import com.st.springsys.sysuser.dao.SysUserDao;
import com.st.springsys.sysuser.entity.SysUser;
import com.st.springsys.sysuser.pojo.SysUserPojo;
import com.st.springsys.sysuser.service.SysUserService;


@Service
public class SysUserServiceImpl implements SysUserService{
@Autowired
	private SysUserDao sysUserDao;
@Override
public Map<String, Object> findObjectById(Integer id) {
//	 1.参数校验
	if(id==null||id<1)
		throw new IllegalArgumentException("参数无效");
//	2.查询用户对应信息
	SysUserPojo user = sysUserDao.findObjectById(id);
	Map<String,Object> map = new HashedMap();
	map.put("user",user);
	return map;
	
}
//@RequiresPermissions("sys::user::valid")
@Override
	public int saveObject(SysUser entity) {
//	1.参数校验
	if(entity==null)
		throw new ServiceException("保存对象不能为空");
	if(StringUtils.isEmpty(entity.getUsername()))
		throw new ServiceException("用户名不能为空");
	if(StringUtils.isEmpty(entity.getPassword()))
		throw new ServiceException("密码不能为空");
//	2.保存用户自身信息
	int rows = sysUserDao.insertObject(entity);
//	加密
	String source = entity.getPassword();
	String salt = UUID.randomUUID().toString();
	SimpleHash sh=
		    new SimpleHash("MD5",source, salt,1);
			entity.setPassword(sh .toHex());
			entity.setSalt(salt);
//	3.返回结果 
		return rows;
	}
@Override
public int updateObject(SysUser entity) {
//	1.参数校验
	if(entity==null)
		throw new ServiceException("保存对象不能为空");
	if(StringUtils.isEmpty(entity.getUsername()))
		throw new ServiceException("用户名不能为空");
//	2.保存用户自身信息
	int rows = sysUserDao.updateObject(entity); 
//	3.返回结果 
	return rows;
}

@Override
	public int validById(Integer id, Integer valid) {
//	1.参数校验
	if(id==null||id<1)
		throw new IllegalArgumentException("ID无效");
	if(valid!=0&&valid!=1)
		throw new IllegalArgumentException("状态无效");
//	2.更新用户状态
	int rows = sysUserDao.validById(id, valid);
	if(rows==0)
		throw new IllegalArgumentException("记录不存在");
//	3.返回结果
		return rows;
	}
@Override
public PageObject<SysUserPojo> findPageObjects(
		String username,
		Integer pageCurrent) {
//	1.参数校验
	if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码不正确");
//	2.查询总记录数并校验
	int rowCount = sysUserDao.getRowCount(username);
	if(rowCount==0)
		throw new IllegalArgumentException("没有对应记录");
//	3.查询当前页记录
	int pageSize=3;
	int startIndex=(pageCurrent-1)*pageSize;
	List<SysUserPojo> records = 
	sysUserDao.findPageObjects(username, startIndex, pageSize);
//	4.对查询结果进行封装并返回
	return new PageObject<>(rowCount, records, pageCurrent, pageSize); 

 }
@Override
public int deleteObject(Integer id) {
	int rows = sysUserDao.delectObject(id);
	return rows;
}

}

