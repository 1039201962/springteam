package com.st.springstore.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.st.springstore.goods.pojo.Goods;

@Mapper
public interface GoodsDao {
	/**
	 * 热销商品,限制10条
	 * @return
	 */
	List<Goods> findHotGoods();
	/**
	 * 查询 排序 分页
	 * @param title
	 * @param orderBy
	 * @param isDesc
	 * @param pageCurrent
	 * @return
	 */
	List<Goods> findGoods(
			@Param("title") String title,
			@Param("orderBy") String orderBy,
			@Param("isDesc") Integer isDesc,
			@Param("pageCurrent") Integer pageCurrent,
			@Param("pageSize") Integer pageSize);
	/**
	 * 根据id查询详细商品数据
	 * @param id
	 * @return
	 */
	Goods findGoodById(Integer id);
	/**
	 * 获取总条数  title允许为空
	 * @param title
	 * @return
	 */
	int getGoodsRows(String title);
}
