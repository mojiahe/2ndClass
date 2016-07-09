package com.qsl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.qsl.pojo.Section;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.service.ICourseService;
import com.qsl.service.ISectionService;
import com.qsl.status.SystemCode;

public class SectionAction {

	//ע��
	@Autowired
	private ISectionService sectionServiceImpl;
	@Autowired
	private ICourseService courseServiceImpl;
	
	private ActionContext act;
	private Map sessionMap;
	private Map requestMap;
	
	private Section section;
	
	
	
	
	/**
	 * @return section
	 */
	public Section getSection() {
		return section;
	}

	/**
	 * @param section Ҫ���õ� section
	 */
	public void setSection(Section section) {
		this.section = section;
	}

	public String sectionDetail(){
		//��ȡ��session��request
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//��ҳ���ȡcid
		String str=request.getParameter("cid");
		int cid=Integer.parseInt(str);
		
		String result=sectionServiceImpl.getSectionByCid(requestMap, cid);
		if(SystemCode.ERROR==result){
			return "fail";
		}

		return "success";
	}
	
	public String getOneSectionAndCourseInfo(){
		//��ȡ��session��request
				act = ActionContext.getContext();
				sessionMap = act.getSession();
				requestMap = (Map)act.get("request");
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				//��ҳ���ȡcid
				String str1=request.getParameter("cid");
				int cid=Integer.parseInt(str1);
				String str2=request.getParameter("sid");
				int sid=Integer.parseInt(str2);
				
				String result=sectionServiceImpl.getSectionCourserInfoByid(requestMap, cid,sid);
				if(SystemCode.ERROR==result){
					return "fail";
				}

				return "success";
	}
	
	
	
	public String getAllSection(){
		//��ȡ��session��request
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		String result=sectionServiceImpl.getAllSection(requestMap,section);
		if(SystemCode.ERROR==result){
			return "fail";
		}

		return "success";
	}
	
	public String delSection(){
		
        HttpServletRequest request = ServletActionContext.getRequest();
		
		//��ҳ���ȡcid
		String str=request.getParameter("sid");
		int sid=Integer.parseInt(str);
		
		
		String result=sectionServiceImpl.delSection(sid);
		if(SystemCode.ERROR==result){
			return "fail";
		}

		return "success";
	}
	
	public String saveEditSection(){
		//��ȡ��session��request
				act = ActionContext.getContext();
				sessionMap = act.getSession();
				requestMap = (Map)act.get("request");
				
		HttpServletRequest request = ServletActionContext.getRequest();
					
					//��ҳ���ȡsid
		String str=request.getParameter("sid");
		int sid=Integer.parseInt(str);
				
		String result=sectionServiceImpl.saveEditSection(requestMap, sid);
		if(SystemCode.ERROR==result){
			return "fail";
		}

	
		return "success";
	}
	
	public String updateSection(){

		String result=sectionServiceImpl.updateSection(section);
		if(SystemCode.ERROR==result){
			return "fail";
		}

		return "success";
	}
	
	public String insertSection(){

		section.setCid(2);
		section.setIs_del(0);
		String result=sectionServiceImpl.insertSection(section);
		if(SystemCode.ERROR==result){
			return "fail";
		}

		return "success";
	}
	
}
