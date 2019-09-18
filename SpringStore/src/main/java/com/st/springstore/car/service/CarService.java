package com.st.springstore.car.service;

import java.util.List;

import com.st.springstore.car.pojo.Car;

public interface CarService {
    /**添加到cookie*/
	void addCookie(Integer userId, Integer num);
    /**添加到购物车*/
	int addCar(Integer userId, Integer goodsId, Integer num);
    
	
//	/**修改cookie中对应的商品*/
//	void updateCookie(Integer goodsId);
//	/**修改购物车对应的商品*/
//	int updateCar(Integer userId,Integer goodsId);
//	
//	/**删除cookie中对应的商品*/
//	void deleteCookie(Integer goodsId);
//	/**删除购物车中对应的商品*/
//	int deleteCar(Integer userId,Integer goodsId);
//	
//	/**展示购物车列表从cookie中获取数据*/
//	void selectCookie();
//	/**展示购物车列表*/
//	List<Car> selectCar(Integer userId);
}
