package com.st.springsys.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysPageController {
	@RequestMapping("/admin")
	public String index() {
		return "sysIndex";
	}
	@RequestMapping("admin/{moudle}/{page}")
	public String pages(@PathVariable String moudle,@PathVariable String page) {
		System.out.println(page);
		return "sys_"+moudle+"_"+page;
	}
}
