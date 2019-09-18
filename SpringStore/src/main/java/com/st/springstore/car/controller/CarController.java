package com.st.springstore.car.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.springstore.car.service.CarService;

@Controller
public class CarController {
   @Autowired
   private CarService carService;
   @RequestMapping("/doAddCar")
   @ResponseBody
   public void doAddCar(Integer userId,Integer goodsId,Integer num) {
	   if(goodsId==null) {
	       carService.addCookie(userId,num); 
	   }
	   carService.addCar(userId,goodsId,num);
   }
}
