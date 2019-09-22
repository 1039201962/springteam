package com.st.springstore.car.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.st.springstore.car.service.CarService;
import com.st.springstore.common.vo.CarGoodsVo;
import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.common.vo.PageObject;

@Controller
@RequestMapping("/car")
public class CarController {
   @Autowired
   private CarService carService;
   @RequestMapping("/doAddCar")/**加入购物车*/
   @ResponseBody
   public JsonResult doAddCar(Integer userId,Integer goodsId,Integer num) {
	   carService.addCar(userId,goodsId,num);
	   return new JsonResult("add...Ok");
   }
   
   @RequestMapping("/doSelectCar")/**展示购物车*/
   @ResponseBody
   public JsonResult doSelectCar(Integer userId) {
	   List<CarGoodsVo> carlist = carService.SelectCar(userId);
	   return new JsonResult(carlist);
   }
   @RequestMapping("/doSelectCarMoney")/**查询用户选中的商品总金额*/
   @ResponseBody
   public JsonResult doSelectCarMoney(Integer...goodsIds){
	   Integer userId=1;
	   double totalMoney = carService.SelectCarMoney(userId,goodsIds);
	   System.out.println(totalMoney);
	   
	   return new JsonResult(totalMoney);
   }
   /**分页查询*/
   @RequestMapping("/doFindPageObjects")
   @ResponseBody
	public JsonResult doFindPageObjects(
			Integer userId,Integer pageCurrent) {
   	PageObject<CarGoodsVo> pageObject=carService.findPageObjects(userId, pageCurrent);
   	return new JsonResult(pageObject);
	}
   
   @RequestMapping("/doUpdateCar")/**修改购物车*/
   @ResponseBody
   public JsonResult doUpdateCar(Integer goodsId,Integer num) {
	   Integer userId=1;
	   carService.updateCar(userId,goodsId,num);
	   return new JsonResult("updata...OK");
   }
   
   @RequestMapping("/doDeleteCar")/**删除购物车*/
   @ResponseBody
   public JsonResult doDelectCar(Integer...goodsIds) {
	   Integer userId=1;
	   carService.delectCar(userId,goodsIds);
	   return new JsonResult("delete...OK");
   }
   
   
}
