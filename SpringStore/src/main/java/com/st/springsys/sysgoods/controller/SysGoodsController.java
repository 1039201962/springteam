package com.st.springsys.sysgoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.springstore.common.vo.JsonResult;
import com.st.springsys.sysgoods.service.SysGoodsService;

@RestController
@RequestMapping("/sysGoods/")
public class SysGoodsController {
	@Autowired
	private SysGoodsService sysGoodsService;

	/**
	 * 查询上架商品，分页
	 * @param pages
	 * @return
	 */
	@RequestMapping("/dofindOnline")
	public JsonResult dofindOnline(@PathVariable String pages,int onSale,Integer pageCurrent) {
		return new JsonResult(sysGoodsService.findOnline(onSale,pageCurrent));
	}
	
	/**
	 * 查询商品 进行标题查询,分类查询,排序,分页显示
	 * @param title
	 * @param orderBy
	 * @param isDesc
	 * @param pageCurrent
	 * @return
	 */
	
	@RequestMapping("/doFindSysGoods")
	public JsonResult doFindSysGoods(String title,Integer categoryId,String orderBy, Integer isDesc, Integer pageCurrent) {
		return new JsonResult(sysGoodsService.findSysGoods(title,categoryId,orderBy, isDesc, pageCurrent));
	}
	
	/**
	 * 根据商品id查询商品信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/doFindSysGoodsById")
	public JsonResult doFindSysGoodsById(Integer id) {
		return new JsonResult(sysGoodsService.findSysGoodById(id));
	}
}
