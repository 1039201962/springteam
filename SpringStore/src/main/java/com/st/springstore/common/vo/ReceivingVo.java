package com.st.springstore.common.vo;

import lombok.Data;
/**
 * 
 * @author zyj
 *
 */
@Data
public class ReceivingVo {
	/**收货地址*/
	private String addr;
	/**收货人电话*/
	private String mobile;
	/**收货人姓名*/
	private String name;
	/**默认地址0/1*/
	private Integer status;
}
