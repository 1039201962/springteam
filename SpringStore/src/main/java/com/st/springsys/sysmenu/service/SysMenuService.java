package com.st.springsys.sysmenu.service;

import java.util.List;
import java.util.Map;

import com.st.springsys.sysmenu.entity.SysMenu;
import com.st.springsys.sysmenu.vo.Node;

public interface SysMenuService {
	//树状图：菜单编辑页面上级菜单呈现
	List<Node> findZtreeMenuNodes();
	//删除
	int deleteObject(Integer id);
	//菜单页面数据呈现
	List<Map<String, Object>> findObjects();
	//添加
	int saveObject(SysMenu entity);
	//修改
	int updateObject(SysMenu entity);

}
