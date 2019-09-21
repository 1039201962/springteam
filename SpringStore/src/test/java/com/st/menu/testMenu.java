package com.st.menu;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springsys.sysmenu.service.SysMenuService;
import com.st.springsys.sysmenu.vo.Node;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testMenu {
	@Autowired
	private SysMenuService sysMenuService;

	@Test
	public void testFindObjects() {
		List<Map<String, Object>> list = sysMenuService.findObjects();
		list.forEach(System.out::println);
	}
	

	@Test
	public void testFindZtreeMenuNodes() {
		List<Node> list = sysMenuService.findZtreeMenuNodes();
		list.forEach(System.out::println);
	}

	@Test
	public void testDeleteObject() {
		int rows = sysMenuService.deleteObject(115);
		System.out.println(rows);
	}
	
	@Test
	public void testUpdateObject() {
		//int rows = sysMenuService.updateObject(entity);
		//System.out.println(rows);
	}
	
	@Test
	public void testSaveObject() {
		//int rows = sysMenuService.saveObject(entity);
		//System.out.println(rows);
	}
	
}
