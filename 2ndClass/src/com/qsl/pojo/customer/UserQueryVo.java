package com.qsl.pojo.customer;

import com.qsl.pojo.User;

public class UserQueryVo extends User{
	private String condition;

	private String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}
