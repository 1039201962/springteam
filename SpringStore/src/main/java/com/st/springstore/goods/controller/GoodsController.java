package com.st.springstore.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.springstore.common.vo.JsonResult;
import com.st.springstore.goods.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	/**
	 * 查询热门商品
	 * @param pages
	 * @return
	 */
	@RequestMapping("/dofindHotGoods")
	public JsonResult dofindHotGoods(@PathVariable String pages) {
		return new JsonResult(goodsService.fingHotGoods());
	}
	/**
	 * 查询商品 进行标题查询,分类查询,排序,分页显示
	 * @param title
	 * @param orderBy
	 * @param isDesc
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("/doFindGoods")
	public JsonResult doFindGoods(String title,Integer categoryId,String orderBy, Integer isDesc, Integer pageCurrent) {
		return new JsonResult(goodsService.findGoods(title,categoryId,orderBy, isDesc, pageCurrent));
	}
}
