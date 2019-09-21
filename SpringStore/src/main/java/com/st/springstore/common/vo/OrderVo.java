package com.st.springstore.common.vo;

import java.util.Date;

import lombok.Data;
@Data
public class OrderVo {
	/** 订单号码 */
	private long order_num;
	/** 订单创建时间 */
	private Date createdTime;
	/** 收货人姓名 */
	private String name;
	/** 支付状态 */
	private int pay_status;
	/** 商品描述*/
	private String title;
	/** 订单总价 */
	private double amount;
	/** 商品数量 */
	private int num;
	/** 商品图片*/
	private String main_img;
}
