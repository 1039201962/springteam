package com.st.springstore.car.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Car implements Serializable{

	private int id;
	private Date createdTime;
	private int userId;
	private int goodsId;
	private int num;
}
