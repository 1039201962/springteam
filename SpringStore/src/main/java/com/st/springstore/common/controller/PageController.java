package com.st.springstore.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	//跳转到登录页面
//	@RequestMapping("/doLoginUI")
//	public String doLoginUI(){
//			return "sys-login";
//	}
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
}
