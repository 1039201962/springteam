package com.st.springsys.sysmenu.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMenuDao {
	/*
	 * 基于菜单id删除关系数据
	 */
	@Delete("delete from role_menu where menu_id = #{id} ")
	int deleteObjectsByMenuId(Integer menuId);
}
