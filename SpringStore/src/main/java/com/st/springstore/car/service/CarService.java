package com.st.springstore.car.service;

import java.util.List;

import com.st.springstore.car.pojo.Car;
import com.st.springstore.common.vo.CarGoodsVo;
import com.st.springstore.common.vo.PageObject;

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
	/**查询用户选中的商品总金额*/
	double SelectCarMoney(Integer userId, Integer...goodsId);
	
	/**
             * 获取当前页的分析信息
     * @param username 用户名
     * @param pageCurrent 当前页页码
     * @return 封装了当前页记录以及页码信息的对象
     */
     PageObject<CarGoodsVo> findPageObjects(
	                    Integer userId,
	                    Integer pageCurrent);
}

