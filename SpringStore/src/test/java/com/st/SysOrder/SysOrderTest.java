package com.st.SysOrder;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springsys.common.vo.PageObject;
import com.st.springsys.sysorder.pojo.SysOrder;
import com.st.springsys.sysorder.service.impl.SysOrderServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysOrderTest {
    @Autowired
	private SysOrderServiceImpl sysosi;
    
    @Test
    public void testfeiye() {
    	PageObject<SysOrder> list = sysosi.findPageObjects("是",1);	
        System.out.println(list.toString());
    }
    
    @Test
    public void testNewOrder() {
    	List<SysOrder> findNewOrder = sysosi.findNewOrder();
    	findNewOrder.forEach(System.out::println);
    }
    
    @Test
    public void findByName() {
      SysOrder list = sysosi.findOrderByName("是");	
      System.out.println(list.toString());
    }
    
    @Test
    public void deleteByIds() {
    	int rows = sysosi.deleteSysOrder(1);
    	System.out.println(rows);
    }
}
