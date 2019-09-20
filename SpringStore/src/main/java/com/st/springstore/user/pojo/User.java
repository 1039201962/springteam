package com.st.springstore.user.pojo;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class User implements Serializable {
	private int id;
	private String username;
	/** 加密处理 */
	private String password;
	private String email;
	/** 电话 */
	private String mobile;
	/**性别：0为女，1为男 */
	private int sex;
	private String salt;
	/** 是否封号 */
	private int valid = 0;
	/** 注册时间  */
	private Date createdTime;
	/** 账户余额不允许被查询出来，带到网页对象 */
	private Double money=0.0;
	/** 支付密码，加密处理，不允许被查询出来显示*/
	private String pay_password ;
	
	private Date modifieTime;		
}
