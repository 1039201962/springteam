package com.st.springstore.goods.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.goods.dao.GoodsDao;
import com.st.springstore.goods.pojo.Goods;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
	@Autowired
	private GoodsDao goodsDao;

	@Test
	public void testGoodsDao() {
		/*
		 * Goods goods = goodsDao.findGoodById(1); System.out.println(goods);
		 */
//		List<Goods> list = goodsDao.findGoods(null, null, null, 0, 5);
//		for (Goods goods2 : list) {
//			System.out.println(goods2);
//		}
//		List<Goods> hotGoods = goodsDao.findHotGoods();
//		System.out.println(hotGoods);
		int rows = goodsDao.getGoodsRows("品");
		System.out.println(rows);

	}
}
