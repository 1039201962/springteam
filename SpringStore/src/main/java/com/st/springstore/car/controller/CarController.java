package com.st.springstore.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.springstore.car.service.CarService;
import com.st.springstore.common.vo.CarGoodsVo;
import com.st.springstore.common.vo.JsonResult;

@Controller
public class CarController {
   @Autowired
   private CarService carService;
   @RequestMapping("/doAddCar")/**加入购物车*/
   @ResponseBody
   public JsonResult doAddCar(Integer userId,Integer goodsId,Integer num) {
	   int rows = carService.addCar(userId,goodsId,num);
	   return new JsonResult("add...Ok");
   }
   
   @RequestMapping("/doSelectCar")/**展示购物车*/
   @ResponseBody
   public JsonResult doSelectCar(Integer userId) {
	   List<CarGoodsVo> carlist = carService.SelectCar(userId);
	   return new JsonResult(carlist);
   }
   @RequestMapping("/doUpdateCar")/**修改购物车*/
   @ResponseBody
   public JsonResult doUpdateCar(Integer userId,Integer goodsId,Integer num) {
	   carService.updateCar(userId,goodsId,num);
	   return null;
   }
   
   @RequestMapping("/doDeleteCar")/**删除购物车*/
   @ResponseBody
   public JsonResult doDelectCar(Integer userId,Integer...goodsIds) {
	   carService.delectCar(userId,goodsIds);
	   return null;
   }
   
   
}
