package com.st.springsys.sysgoods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.st.springsys.sysgoods.pojo.SysGoods;

@Mapper
public interface SysGoodsDao {
	/**
	 * 将商品存入数据库
	 * @param sysGoods
	 * @return
	 */
	int insertSysGoods(SysGoods sysGoods);
	/**
	 * 上架商品
	 * @return
	 */
	List<SysGoods> findOnline(
			@Param("onSale") int onSale,
			@Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);
	/**
	 * 查询 排序 分页
	 * @param title
	 * @param orderBy
	 * @param isDesc
	 * @param pageCurrent
	 * @return
	 */
	List<SysGoods> findSysGoods(
			@Param("title") String title,
			@Param("categoryId") Integer categoryId,
			@Param("orderBy") String orderBy,
			@Param("isDesc") Integer isDesc,
			@Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);
	/**
	 * 根据id查询详细商品数据
	 * @param id
	 * @return
	 */
	SysGoods findSysGoodsById(Integer id);
	/**
	 *获取上架总条数 
	 * @param onSale
	 * @return
	 */
	int getOnlineRows(int onSale);
	
	/**
	 * 获取总条数  title允许为空
	 * @param title
	 * @return
	 */
	int getSysGoodsRows(String title);
}
