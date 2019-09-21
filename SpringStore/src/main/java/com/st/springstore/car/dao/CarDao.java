package com.st.springstore.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.st.springstore.car.pojo.Car;

@Mapper
public interface CarDao {
    /**根据用户id和商品id查询购物车中*/
	Car findById(Integer userId, Integer goodsId);
    /**添加到购物车列表*/
	int addCar(Car car2);
    
	/**修改购物车商品商品信息(数量)*/
	int updateCar(Integer userId, Integer goodsId,Integer num);
	
	/**根据用户Id查询出购车列表中此用户的所有加入到购物车的商品信息*/
	List<Car> findByUserId(Integer userId);
	
	/**根据用户Id和商品Id删除购物车中对应的商品*/
	int delectCarByGoodsId(Integer userId, Integer...goodsIds);
	
	/**查询用户选中的商品总金额*/
	List<Car> findByGoodsId(Integer userId, Integer...goodsIds);
	
	/***
	 * 基于条件查询总记录数
	 * @param userId 查询条件
	 * @return 总记录数
	 */
	int getRowCount(@Param("userId")Integer userId);
	/**
	 * 基于条件查询当前页要呈现的记录
	 * @param userId 查询条件
	 * @param startIndex 当前页起始位置
	 * @param pageSize 页面大小(每页最多要呈现的记录数)
	 * @return 当前页面要呈现的记录
	 */
	List<Car> findPageObjects(
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}

