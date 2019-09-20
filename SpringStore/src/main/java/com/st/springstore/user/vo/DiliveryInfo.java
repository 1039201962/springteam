package com.st.springstore.user.vo;

import lombok.Data;

/**封装收货地址信息*/
@Data
public class DiliveryInfo {
	private Integer id;
	private Integer userId;
	private Integer mobile;
	private String addr;
	private String name;
	private int status;
	public DiliveryInfo() {
		super();
	}
	public DiliveryInfo(Integer id, Integer userId, Integer mobile, String addr, String name, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.mobile = mobile;
		this.addr = addr;
		this.name = name;
		this.status = status;
	}
	
}
