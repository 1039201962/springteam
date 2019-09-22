package com.st.springstore.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/{pages}")
	public String pages(@PathVariable String pages) {
		return pages;
	}
	/**
	 * 跳转到搜索结果页
	 * @return
	 */
	@RequestMapping("/doJumpPageResult")
	public String doJumpPageResult() {
		return "shop-search-result";
	}
	/**
	 * 跳转到所有商品页
	 */
	@RequestMapping("/doJumpGoodsList")
	public String doJumpGoodsList() {
		return "shop-product-list";
	}
	/**
	 **查看订单详情信息的页面
	 */
	@RequestMapping("/seeOrderInfo")
	public String seeOrderInfo(){
		
		
		return "order_info";
	}
}
