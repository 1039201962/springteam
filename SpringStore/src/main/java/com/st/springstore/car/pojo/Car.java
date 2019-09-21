package com.st.springstore.car.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7369742005419284502L;
	private int id;
	private Date createdTime;
	private int userId;
	private int goodsId;
	private int num;
}
