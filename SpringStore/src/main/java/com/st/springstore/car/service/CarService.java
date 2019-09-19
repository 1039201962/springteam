package com.st.springstore.car.service;

import java.util.List;

import com.st.springstore.common.vo.CarGoodsVo;

public interface CarService {
//    /**添加到cookie*/
//	void addCookie(Integer userId, Integer num);
    /**添加到购物车*/
	int addCar(Integer userId, Integer goodsId, Integer num);
   
	/**根据用户id查询购物车中的商品信息*/
	List<CarGoodsVo> SelectCar(Integer userId);
    
    /**修改购物车对应的商品*/
	int updateCar(Integer userId,Integer goodsId,Integer num);
	
	/**删除购物车中对应的商品*/
	int delectCar(Integer userId, Integer...goodsIds);
	
//	/**删除cookie中对应的商品*/
//	void deleteCookie(Integer goodsId);
//	
//	int deleteCar(Integer userId,Integer goodsId);
//	
//	/**展示购物车列表从cookie中获取数据*/
//	void selectCookie();
//	/**展示购物车列表*/
//	List<Car> selectCar(Integer userId);
}
