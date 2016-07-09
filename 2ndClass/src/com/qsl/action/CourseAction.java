package com.qsl.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.qsl.pojo.CourseInfo;
import com.qsl.pojo.Type;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.pojo.customer.CourseQueryVo;
import com.qsl.service.ICourseService;
import com.qsl.status.SystemCode;

public class CourseAction {

	//注解
	@Autowired
	private ICourseService courseServiceImpl;
	
	private ActionContext act;
	private Map sessionMap;
	private Map requestMap;
	
	private CourseCustom courseCustom;
	
	private CourseQueryVo courseQueryVo;
	
	
	
	public CourseQueryVo getCourseQueryVo() {
		return courseQueryVo;
	}

	public void setCourseQueryVo(CourseQueryVo courseQueryVo) {
		this.courseQueryVo = courseQueryVo;
	}

	private Type type;
	
	
	
	/**
	 * @return type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type 要设置的 type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	public CourseCustom getCourseCustom() {
		return courseCustom;
	}

	public void setCourseCustom(CourseCustom courseCustom) {
		this.courseCustom = courseCustom;
	}

	public String getCourseOnHome(){
		
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		String result=courseServiceImpl.getCourseOnHome(requestMap);
		if(SystemCode.SUCCESS==result){
			return "success";
		}
		
		return "fail";
	}
	
	public String insertCourse(){
		
		
	 
		
		 return "success";
	}
	
	public String removeCourseByCid(){
		
		//获取request
    	HttpServletRequest request = ServletActionContext.getRequest();
  		//sss
  		//从页面获取id
  		String str1=request.getParameter("cid");
  		int cid=Integer.parseInt(str1);
  		
  		String str2=request.getParameter("teaid");
  		int tea_id=Integer.parseInt(str2);
  		
  	
  		
  		CourseInfo courseInfo=new CourseInfo();
  		CourseCustom del_courseCustom=new CourseCustom();
  	
  		
  		courseInfo.setCid(cid);
  		courseInfo.setTea_id(tea_id);
  		courseInfo.setIs_del(1);
  		
  		del_courseCustom.setCid(cid);
  		del_courseCustom.setCourseInfo(courseInfo);
  		
		
		String result=courseServiceImpl.removeCourse(del_courseCustom);
		if(result==SystemCode.ERROR){
			return "fail";
		}
		return "success";
	}
	
	public String updateCourseAndInfo(){
		
		String result=courseServiceImpl.modifyCourseInfo(courseCustom);
		if(result==SystemCode.ERROR){
			return "fail";
		}
		return "success";
	}
	
	public String getCourseAndInfoByType(){
		
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		String result=courseServiceImpl.getAllCourseAndInfoByType(requestMap, type);
		if(SystemCode.SUCCESS==result){
			return "success";
		}
		
		return "fail";
		
	}
	
	/**
	 * 后台获取所有课程的信息
	 * @return
	 */
	public String getAllCourseAndInfoType(){
		
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		String result=courseServiceImpl.getCourseOnHome(requestMap);
		
		if(SystemCode.SUCCESS==result){
			return "success";
		}
		
		return "fail";
		
	}
	
	public String getCourseByName(){
		
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		String result=courseServiceImpl.getCourseByName(requestMap, courseQueryVo);
		
		if(SystemCode.SUCCESS==result){
			return "success";
		}
		
		return "fail";
		
		
	}
	
	public String saveEditCourse(){
		
		//获取request
    	HttpServletRequest request = ServletActionContext.getRequest();
  		
  		//从页面获取id
  		String str1=request.getParameter("cid");
  		int cid=Integer.parseInt(str1);
		
  		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		CourseQueryVo courseQueryVo_save=new CourseQueryVo();
		courseQueryVo_save.setCid(cid);
		System.out.println("save cid:"+cid);
		
		System.out.println(courseQueryVo_save.getCid());
		
		String result=courseServiceImpl.getCourseById(requestMap, courseQueryVo_save);
		
		if(SystemCode.SUCCESS==result){
			return "success";
		}
		
		return "fail";
	}
	
	public String gotoPageCourseInsert(){
		return "success";
	}
	
	
}
