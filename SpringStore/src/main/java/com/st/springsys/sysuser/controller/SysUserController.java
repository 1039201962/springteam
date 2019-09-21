package com.st.springsys.sysuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.springstore.common.vo.JsonResult;
import com.st.springsys.sysuser.entity.SysUser;
import com.st.springsys.sysuser.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysUserService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(
			Integer id) {
		return new JsonResult(sysUserService.findObjectById(id));
	
	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(
			SysUser entity) {
		sysUserService.saveObject(entity);
		return new JsonResult("save OJBK");
	}
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(
			SysUser entity) {
		sysUserService.updateObject(entity);
		return new JsonResult("update OJBK");
	}
	
	@RequestMapping("dovalidById")
	public JsonResult dovalidById(Integer id,Integer valid) {
		sysUserService.validById(id, valid);
		return new JsonResult("update OJBK");
	}
	@GetMapping("doFindPageUsers") 
public JsonResult doFindPageUsers(String username,Integer pageCurrent) {
return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));	
}
}
