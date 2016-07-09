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

	//ע��
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
	  	    System.out.println("��ӳɹ�");
	  	    FileOperation.fileUpload(file, "", "");
	  		return "success";
	  	   
	  	}
	  	else{
	  		//��Ҫ��ӵ��û��Ѿ�����
	  		return "fail";
	  	}
	}
	
      public String delTeacher(){
		
    	//��ȡrequest
    	HttpServletRequest request = ServletActionContext.getRequest();
  		
  		//��ҳ���ȡid
  		String str=request.getParameter("id");
  		int id=Integer.parseInt(str);  
    	
  		Teacher del_teacher=new Teacher();
  		del_teacher.setTea_id(id);
  		
  		
		String result=teacherServiceImpl.delTeacher(del_teacher);
	  	if(result==SystemCode.SUCCESS){
	  	    System.out.println("ɾ���ɹ�");
	  		return "success";
	  	   
	  	}
	  	else{
	  		//��Ҫɾ�����û�������
	  		return "fail";
	  	}
	}
      
      

      public String updateTeacher(){
		
    	 
    	  
		String result=teacherServiceImpl.EditTeacher(teacher);
	  	if(result==SystemCode.SUCCESS){
	  	    System.out.println("���³ɹ�");
	  		return "success";
	  	   
	  	}
	  	else{
	  		//��Ҫ���µ��û�������
	  		return "fail";
	  	}
	} 
      
      
      public String saveEditTeacher(){
    	
    	act = ActionContext.getContext();
  		sessionMap = act.getSession();
  		requestMap = (Map)act.get("request"); 
    	  
    	//��ȡrequest
        HttpServletRequest request = ServletActionContext.getRequest();
    	//��ҳ���ȡid
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
