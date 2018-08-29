package com.doudou.bill.base;



import com.doudou.bill.dto.UserDto;

import java.io.Serializable;


/**
 * 基础类查询
 * 
 * @author cango
 *
 */
public class BaseQO implements Serializable{

	private static final long serialVersionUID = -759399335985770176L;

	public UserDto userInfo;

	public UserDto getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserDto userInfo) {
		this.userInfo = userInfo;
	}
}
