package com.st.springstore.car.dao;

import java.util.List;

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
	
	/**根据用户Id查询出购车列表中此用户的所有加入到购物车的商品信息*/
	List<Car> findByUserId(Integer userId);
	
	/**根据用户Id和商品Id删除购物车中对应的商品*/
	int delectCarByGoodsId(Integer userId, Integer[] goodsIds);
}
