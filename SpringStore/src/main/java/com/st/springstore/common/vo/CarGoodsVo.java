package com.st.springstore.common.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class CarGoodsVo implements Serializable{
  /** 
	 */
private static final long serialVersionUID = -1147636858308856366L;
  
  private Integer goodsId;
  //商品数量
  private Integer num;
  //商品主要描述
  private String descript;
  //商品的主要图片
  private String main_img;
}
