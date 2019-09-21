package com.st.SysGoods;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.common.vo.PageObject;
import com.st.springsys.sysgoods.dao.SysGoodsDao;
import com.st.springsys.sysgoods.pojo.SysGoods;
import com.st.springsys.sysgoods.service.SysGoodsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSysGoods {
   @Autowired
   private SysGoodsDao sgd;
   @Autowired
   private SysGoodsService sgs;
   
   @Test
   public void findOnline() {
	   List<SysGoods> list = sgd.findOnline(1, 0,2);
	   list.forEach(System.out::println);	
	   PageObject<SysGoods> list1 = sgs.findOnline(1,1);
	   System.out.println(list1);
	   SysGoods findSysGoodsById = sgd.findSysGoodsById(1);
	   System.out.println(findSysGoodsById);
	   int a = sgd.getOnlineRows(1);
	   System.out.println(a);
	   int sysGoodsRows = sgd.getSysGoodsRows("树");
	   System.out.println(sysGoodsRows);
   }
}
