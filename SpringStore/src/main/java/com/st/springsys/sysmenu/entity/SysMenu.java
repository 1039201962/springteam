package com.st.springsys.sysmenu.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4711744510605082146L;
	private Integer id;
	private String name;
	private Integer parent_id;
	private String permission;

}
