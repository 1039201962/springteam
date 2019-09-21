package com.st.sysuser;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.common.vo.PageObject;
import com.st.springsys.sysuser.dao.SysUserDao;
import com.st.springsys.sysuser.pojo.SysUserPojo;
import com.st.springsys.sysuser.service.impl.SysUserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest1 {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
  private SysUserServiceImpl sus;
	
	@Test
	public void testUserDao() {
		System.out.println("------");
		System.out.println(sysUserDao);
		System.out.println("------");
		List<SysUserPojo> list = sysUserDao.findPageObjects("test", 0, 5);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			SysUserPojo sysUserPojo = (SysUserPojo) iterator.next();
			System.out.println(sysUserPojo);
		}
	}
	
	@Test
	public void testFind() {
		PageObject<SysUserPojo> list = sus.findPageObjects("test", 1);
		System.out.println(list);
	}
	
	@Test
	public void deleteT() {
		int rows = sus.deleteObject(2);
		System.out.println(rows);
	}
	/*
	 * @Test public void testVaild() { int rows = sus.vaildById(1,1);
	 * System.out.println(rows); }
	 */
}
