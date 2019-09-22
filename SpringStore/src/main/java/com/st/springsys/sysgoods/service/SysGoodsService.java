package com.st.springsys.sysgoods.service;


import com.st.springstore.common.vo.PageObject;
import com.st.springsys.sysgoods.pojo.SysGoods;

public interface SysGoodsService {
	/**
	 * 上架商品
	 * @return list
	 */
	PageObject<SysGoods> findOnline(int onSale,Integer pageCurrent);
	/**
	 * 根据输入的字符进行模糊查询,并进行排序  并且进行分页显示
	 * (如果没有输入查询数据,默认查询所有,默认排序销量从高到低)
	 * (如果查询没有直接结果,默认查询分类信息)
	 * (根据所选排序进行排序:最新/销量/价格)
	 * 并且做下一页的数据缓存
	 * @param title
	 * @return
	 */
	PageObject<SysGoods> findSysGoods(String title,Integer categoryId,String orderBy,Integer isDesc,Integer pageCurrent);
	/**
	 * 根据商品id进行商品的详情显示
	 * @param id
	 * @return
	 */
	SysGoods findSysGoodById(Integer id);
}
