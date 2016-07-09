package com.qsl.pojo.customer;

import com.qsl.pojo.Course;
import com.qsl.pojo.Type;

public class CourseQueryVo extends Course{
	private Type type;
	
	private String parName;
	
	private String condition;

	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}
