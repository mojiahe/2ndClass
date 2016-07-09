package com.qsl.action;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.pojo.Type;

import com.opensymphony.xwork2.ActionContext;
import com.qsl.service.ITypeService;
import com.qsl.status.SystemCode;

public class TypeManagerAction {

	// ×¢½â
	@Autowired
	private ITypeService typeServiceImpl;
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private ActionContext act;
	private Map sessionMap;
	private Map requestMap;

	/*
	 * { act = ActionContext.getContext(); sessionMap = act.getSession();
	 * requestMap = (Map) act.get("request");
	 * 
	 * }
	 */
	


	public String getTypeByName() {
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map) act.get("request");

		String result = typeServiceImpl.getType(requestMap, type);
		if (result == SystemCode.ERROR) {
			return "getType_fail";
		}
		return "getType_success";
	}

	public String deletetype() {

		type.setIs_del(1);
		String result = typeServiceImpl.delType(type);
		if (result == SystemCode.ERROR) {

			return "delType_fail";

		}
		return "delType_success";

	}

	public String addtype() {

		String result = typeServiceImpl.addType(type);

		if (result == SystemCode.SUCCESS) {

			return "addtype_success";

		} else {

			return "addtype_fail";
		}
	}
    public String edit(){
    	act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map) act.get("request");

		String result = typeServiceImpl.selectById(requestMap, type);
		if (result == SystemCode.ERROR) {
			return "getTypeById_fail";
		}
		return "getTypeById_success";
    	
    }
   
    public String add(){
		return "add_success";
    	
    }
	public String edittype() {

		String result = typeServiceImpl.EditType(type);
		if (result == SystemCode.ERROR) {

			return "editType_fail";
		} else {

			return "editType_success";
		}

	}

}
