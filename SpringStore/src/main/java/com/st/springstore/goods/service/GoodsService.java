package com.st.springstore.goods.service;

import com.st.springstore.goods.pojo.Goods;

public interface GoodsService {
	
	Goods findGoodsByName(String GoodsName);
	
	Goods findGoodsByType();

}
