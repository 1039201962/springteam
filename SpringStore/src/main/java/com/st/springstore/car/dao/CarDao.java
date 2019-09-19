package com.st.springstore.car.dao;

import org.apache.ibatis.annotations.Mapper;

import com.st.springstore.car.pojo.Car;

@Mapper
public interface CarDao {
    /**根据用户id和商品id查询购物车中*/
	Car findById(Integer userId, Integer goodsId);
    /**添加到购物车列表*/
	int addCar(Car car2);
    
	/**修改购物车商品商品信息(数量)*/
	int updateCar(Integer userId, Integer goodsId,Integer num);
}
