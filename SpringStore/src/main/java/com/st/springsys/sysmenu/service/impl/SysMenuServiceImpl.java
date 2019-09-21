package com.st.springsys.sysmenu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.st.springstore.common.exception.ServiceException;
import com.st.springsys.sysmenu.dao.SysMenuDao;
import com.st.springsys.sysmenu.entity.SysMenu;
import com.st.springsys.sysmenu.service.SysMenuService;
import com.st.springsys.sysmenu.vo.Node;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;

	//重写修改
	@Override
	public int updateObject(SysMenu entity) {
		// 合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		// 更新数据
		int rows = sysMenuDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 返回数据
		return rows;
	}
	
	//重写新增
	@Override
	public int saveObject(SysMenu entity) {
		// 合法验证
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("菜单名不能为空");
		int rows = 0;
		try {
			rows = sysMenuDao.insertObject(entity);
		} catch (Throwable e) {
			log.error(e.getMessage());
			// 报警
			throw new ServiceException("系统维护中");

		}
		// 返回结果
		return rows;
	}
	
	//重写树状图
	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}
	
	//重写删除
	@Override
	public int deleteObject(Integer id) {
		// 合法验证
		if (id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		int rowCount = sysMenuDao.getChildCount(id);
		if (rowCount > 0)
			throw new ServiceException("请先删除子菜单");
		int rows = sysMenuDao.deleteObject(id);
		if (rows == 0)
			throw new ServiceException("菜单可能不存在");
		// 返回数据
		return rows;
	}
	
	//重写菜单页面数据呈现
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		// 合法验证
		if (list.size() == 0)
			throw new ServiceException("no records");
		// 返回数据
		return list;
	}

}
