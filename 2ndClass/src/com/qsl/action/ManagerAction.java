package com.qsl.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;
import com.qsl.pojo.Manager;
import com.qsl.pojo.NewManager;
import com.qsl.service.IManagerService;
import com.qsl.status.SystemCode;

public class ManagerAction {
	
	@Autowired
	private IManagerService managerServiceImpl;
	private NewManager manager;	
	private ActionContext act;
	private Map request;
	private Map session;
	
	 /*  ��̬��
	 *    ÿ��ִ�� ManagerAction֮ǰ����
	 */
	/*{
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
	}*/
	

	public NewManager getManager() {
		return manager;
	}

	public void setManager(NewManager manager) {
		this.manager = manager;
	}

	public String login(){
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
		String message = "";
		String result = managerServiceImpl.login(session, manager);
		if(result == SystemCode.ERROR_PWD){
			message = "����������������롣";
		}
		if(result == SystemCode.NOT_SUCH_USER){
			message = "�û��������ڣ����������롣";
		}
		if(!"".equals(message)){
			request.put("message", message);
			return "login_fail";
		}
		return "login_success";
				
	}
	
	public String findManagerPwd(){
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
		String message = "";
		String result = managerServiceImpl.findManagerPwd(manager);
		
		if(result == SystemCode.ERROR_TEL){
			message = "�绰���벻���ڣ����������롣";
		}
		if(result == SystemCode.NOT_SUCH_USER){
			message = "�û��������ڣ����������롣";
		}
		if(!"".equals(message)){
			request.put("message", message);
			return "forget_fail";
		}
		session.put("manager", manager);
		return "forget_success";	
	}
	
	public String add(){
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
		String message = "";
		String result = managerServiceImpl.add(session, manager);
		
		if(result == SystemCode.EXIST_USER){
			message = "���û����Ѿ����ڣ�";
		}
		if(result == SystemCode.EXIST_TEL){
			message = "һ���绰����ֻ��ע��һ���˻���";
		}
		if(result == SystemCode.SUCCESS){
			message = "�ɹ�����һ������Ա���ݣ�";
		}
		if(!"".equals(message)){
			request.put("message", message);
			return "add_fail";
		}
		return "add_success";
		
	}
	
	public String resetManagerPwd(){
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
		String message = "";
		String result = managerServiceImpl.updateManagerPwd(session, manager);		
		if(result == SystemCode.SUCCESS){
			message = "�޸�����ɹ���";
			request.put("message", message);
		}
		if(result == SystemCode.ERROR_PWD){
			message = "����������������룡";
			request.put("message", message);
			return "reset_fail";
		}
		return "reset_success";		
	}
	
	public String resetManagerMessage(){
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
		String message = "";
		String result = managerServiceImpl.updateManagerInfo(session, manager);
		if(result == SystemCode.INFO_SUCCESS){
			message = "�޸���Ϣ�ɹ���";
			request.put("message", message);
		}
		return "info_success";
	}
	
	public String exit() {
		act = ActionContext.getContext();
		request = (Map) act.get("request");
		session = act.getSession();
		String message = "�˳��ɹ���";
		request.put("message", message);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		manager.setLasttime(dateString);
		managerServiceImpl.updateManagerInfo(session, manager);
		return "exit_success";
	}	
	
	public String modifypwd(){
		return "modifypwd_success";
	}
	public String modify(){
		return "modify_success";
	}
	public String index(){
		return "index_success";
		
	}
}
