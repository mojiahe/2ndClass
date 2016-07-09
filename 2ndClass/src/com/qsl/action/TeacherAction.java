package com.qsl.action;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.qsl.pojo.Teacher;
import com.qsl.service.ITeacherService;
import com.qsl.status.SystemCode;
import com.qsl.util.FileOperation;

public class TeacherAction {

	//注解
	@Autowired
	private ITeacherService teacherServiceImpl; 
	
	private Teacher teacher;

	private File file;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	private ActionContext act;
	private Map sessionMap;
	private Map requestMap;
	

	public String getAllTeacher(){
		
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		
		String result=teacherServiceImpl.getTeacher(sessionMap, null);
	  	if(result==SystemCode.SUCCESS){
	  	   System.out.println(requestMap.get("teacherlist"));
	  		return "success";
	  	   
	  	}
	  	else{
	  		
	  		return "fail";
	  	}
		
	
		
	}
public String getTeacherByName(){
		
		act = ActionContext.getContext();
		sessionMap = act.getSession();
		requestMap = (Map)act.get("request");
		
		
		String result=teacherServiceImpl.getTeacher(sessionMap, teacher);
	  	if(result==SystemCode.SUCCESS){
	  	   System.out.println(requestMap.get("teacherlist"));
	  		return "success";
	  	   
	  	}
	  	else{
	  		
	  		return "fail";
	  	}
		
	
		
	}
	
	
	public String insertTeacher(){
		
		teacher.setIs_del(0);
		System.out.println(teacher.getIs_del());
		
		if (file!=null) {
			teacher.setPic(file.getName());
			
		}
		String result=teacherServiceImpl.addTeacher(teacher);
	  	if(result==SystemCode.SUCCESS){
	  	    System.out.println("添加成功");
	  	    FileOperation.fileUpload(file, "", "");
	  		return "success";
	  	   
	  	}
	  	else{
	  		//需要添加的用户已经存在
	  		return "fail";
	  	}
	}
	
      public String delTeacher(){
		
    	//获取request
    	HttpServletRequest request = ServletActionContext.getRequest();
  		
  		//从页面获取id
  		String str=request.getParameter("id");
  		int id=Integer.parseInt(str);  
    	
  		Teacher del_teacher=new Teacher();
  		del_teacher.setTea_id(id);
  		
  		
		String result=teacherServiceImpl.delTeacher(del_teacher);
	  	if(result==SystemCode.SUCCESS){
	  	    System.out.println("删除成功");
	  		return "success";
	  	   
	  	}
	  	else{
	  		//需要删除的用户不存在
	  		return "fail";
	  	}
	}
      
      

      public String updateTeacher(){
		
    	 
    	  
		String result=teacherServiceImpl.EditTeacher(teacher);
	  	if(result==SystemCode.SUCCESS){
	  	    System.out.println("跟新成功");
	  		return "success";
	  	   
	  	}
	  	else{
	  		//需要跟新的用户不存在
	  		return "fail";
	  	}
	} 
      
      
      public String saveEditTeacher(){
    	
    	act = ActionContext.getContext();
  		sessionMap = act.getSession();
  		requestMap = (Map)act.get("request"); 
    	  
    	//获取request
        HttpServletRequest request = ServletActionContext.getRequest();
    	//从页面获取id
  		String str=request.getParameter("id");
  		int id=Integer.parseInt(str);  
    	
  		String result=teacherServiceImpl.getTeacherById(requestMap, id);
    	
  		if(SystemCode.ERROR==result){
    		return "fail";
    	}
    	
    	
    	  return "success";
      }
      public String gotoPageTeacherInsert() {
		return "success";
	}
      
}
