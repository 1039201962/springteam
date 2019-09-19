package com.st.springstore.order.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	/** 订单的id */
	private int id;
	/** 下单用户的id */
	private int userId;
	/** 订单号码 */
	private long order_num;
	/** 商品的id信息 */
	private int goodsId;
	/** 商品总数量  */
	private int num;
	/** 订单创建时间 */
	private Date createdTime;
	/** 支付状态 */
	private int pay_status;
	/** 订单金额 */
	private Double amount;
	/** 是否有效 */
	private int valid;
	/** 收货地址 */
	private String addr;
	/** 收货电话 */
	private String mobile;
	/** 收货人姓名 */
	private String name;
}
