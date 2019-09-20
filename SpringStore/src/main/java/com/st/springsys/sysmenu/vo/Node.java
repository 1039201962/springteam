package com.st.springsys.sysmenu.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Node implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1209883884902789587L;
	private Integer id;
	private String name;
	private Integer parent_id;
	private String permission;
}
