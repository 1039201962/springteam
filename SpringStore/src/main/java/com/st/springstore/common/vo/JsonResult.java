package com.st.springstore.common.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JsonResult implements Serializable {
	
	private static final long serialVersionUID = -4982299683452976107L;
	/**状态码*/
	private int state = 1;
    /**状态码对应的状态信息*/
    private String message="ok";
    /**正常数据*/
    private Object data;
    public JsonResult(String message) {
    	this.message=message;
    }
    public JsonResult(Object data) {
    	this.data=data;
    }
    /**封装异常数据*/
    public JsonResult(Throwable e) {
    	this.state=0;
    	this.message=e.getMessage();
    }

}
