package com.st.springstore.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.springstore.car.service.CarService;
import com.st.springstore.common.vo.JsonResult;

@Controller
public class CarController {
   @Autowired
   private CarService carService;
   @RequestMapping("/doAddCar")
   @ResponseBody
   public JsonResult doAddCar(Integer userId,Integer goodsId,Integer num) {
	   int rows = carService.addCar(userId,goodsId,num);
	   return new JsonResult("add...Ok");
   }
   
   @RequestMapping("/doSelectCar")
   @ResponseBody
   public JsonResult doSelectCar(Integer userId) {
	   carService.SelectCar(userId);
	   return null;
   }
}
