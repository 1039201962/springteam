package com.st.springsys.sysgoods.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysGoods implements Serializable{
	private static final long serialVersionUID = -4484894467196300994L;
	private int id ;
	private String title;
	private double price;
	private String descript;
	private int goodsId;
	private String main_img;
	private String des_img;
	/** 创建时间 */
	private Date createdTime;
	/** 修改时间 */
	private Date modifieTime;
	/** 推荐状态 */
	private int reCommend_status;	
	/** 销量 */
	private int sale_num;
	/**分类*/
	private String categoryId;
	/** 是否上架 */
	private int onSale;
}