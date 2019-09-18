package com.st.springstore.goods.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Goods {
	private int id ;
	private String title;
	private double price;
	private String descript;
	private int goods_num;
	private String main_img;
	private String des_img;
	/** 创建时间 */
	private Date createdTime;
	/** 修改时间 */
	private Date modifieTime;
	/** 推荐状态 */
	private int reCommend_status;	
}
