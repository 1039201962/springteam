package com.st.springstore.goods.service;

import java.util.List;

import com.st.springstore.common.vo.PageObject;
import com.st.springstore.goods.pojo.Goods;
/**
 * 此接口是index页面所需的业务接口
 * @author lyl
 *
 */
public interface GoodsService {
	
	/**
	 * 热销商品,限制10条
	 * @return list
	 */
	List<Goods> fingHotGoods();
	/**
	 * 根据输入的字符进行模糊查询,并进行排序  并且进行分页显示
	 * (如果没有输入查询数据,默认查询所有,默认排序销量从高到低)
	 * (如果查询没有直接结果,默认查询分类信息)
	 * (根据所选排序进行排序:最新/销量/价格)
	 * 并且做下一页的数据缓存
	 * @param title
	 * @return
	 */
	PageObject<Goods> findGoods(String title,Integer categoryId,String orderBy,Integer isDesc,Integer pageCurrent);
	/**
	 * 根据商品id进行商品的详情显示
	 * @param id
	 * @return
	 */
	Goods findGoodById(Integer id);
}
