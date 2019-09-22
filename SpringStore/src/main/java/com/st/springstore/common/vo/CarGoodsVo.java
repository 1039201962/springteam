package com.st.springstore.common.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class CarGoodsVo implements Serializable{
  /** 
	 */
private static final long serialVersionUID = -1147636858308856366L;
  //商品的Id
  private Integer goodsId;
  //商品数量
  private Integer num;
  //商品主要描述
  private String descript;
  //商品的主要图片
  private String main_img;
  //同一种商品的总金额
  private double total;
  //商品的单价
  private double price;
}
