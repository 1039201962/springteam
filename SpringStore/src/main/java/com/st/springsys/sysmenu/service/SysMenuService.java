package com.st.springsys.sysmenu.service;

import java.util.List;
import java.util.Map;

import com.st.springsys.sysmenu.entity.SysMenu;
import com.st.springsys.sysmenu.vo.Node;

public interface SysMenuService {

	List<Node> findZtreeMenuNodes();

	int deleteObject(Integer id);

	List<Map<String, Object>> findObjects();

	int saveObject(SysMenu entity);
	
	int updateObject(SysMenu entity);

}
