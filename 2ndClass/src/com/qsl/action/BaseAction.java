package com.qsl.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements RequestAware, SessionAware, ApplicationAware, ServletResponseAware {
	// ͨ��IOC��ȡStruts��װ��<Map>���Ͷ���
	protected Map requestMap;
	protected Map sessionMap;
	protected Map applicationMap;
	protected HttpServletResponse response;

	@Override
	public void setRequest(Map<String, Object> req) {
		requestMap = req;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		applicationMap = application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

}
