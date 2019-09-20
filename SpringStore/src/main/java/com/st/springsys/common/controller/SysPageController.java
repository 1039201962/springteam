package com.st.springsys.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysPageController {
	@RequestMapping("/admin")
	public String index() {
		return "sys-index";
	}

	@RequestMapping("/admin/{page}")
	public String pages(@PathVariable String page) {
		return "sys-" + page;
	}

}
