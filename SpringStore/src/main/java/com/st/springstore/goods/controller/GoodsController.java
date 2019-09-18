package com.st.springstore.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {
	@RequestMapping("/{pages}")
	public String test(@PathVariable String pages) {
		return pages;
	}
}
