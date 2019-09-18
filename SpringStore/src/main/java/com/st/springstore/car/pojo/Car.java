package com.st.springstore.car.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Car {

	private int id;
	private Date createTime;
	private int userId;
	private int goodsId;
	private int num;
}
