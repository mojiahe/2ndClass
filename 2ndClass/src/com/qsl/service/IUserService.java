package com.qsl.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.qsl.pojo.User;
import com.qsl.pojo.customer.UserQueryVo;
import com.qsl.pojo.customer.UserView;

public interface IUserService {

	/**
	 * 
	* @Title: login
	* @Description: �û���¼�������û������username��password�����е�¼
	* @param user �洢�û���Ϣ
	* @param session �Ự��Ϣ�����ڱ����¼�ɹ����û���Ϣ
	* @return
	* @return String   ������Ӧ״̬��LoginCode 
	*
	 */
	public String login(Map session,User user);
	
	/**
	 * 
 	* @Title: register
	* @Description: �û�ע�ᡣ�û���дusername,password,tel�����ע��
	* @param user �û���ע����Ϣ
	* @param session �Ự��Ϣ�����ڱ���ע��ɹ����û���Ϣ
	* @return String  ������Ӧ״̬��SystemCode 
	*
	 */
	public String register(Map session,User user);

	/**
	 * 
	* @Title: findUserPwd
	* @Description: �һ����롣���ȸ����û����͵绰�����û�������û������������û��޸�����
	* @param ��Ҫ���ҵ��û���Ϣ
	* @return String  ������Ӧ״̬��SystemCode   
	*
	 */
	
	public String findUserPwd(UserView user);
	
	/**
	 * 
	* @Title: updateUserInfo
	* @Description: �����û���Ϣ������username�޸��û���Ϣ
	* @param user	Ҫ���µ��û�����
	* @param session �Ự��Ϣ�����ڱ����޸ĳɹ����û���Ϣ
	* @return String    
	*
	 */
	public String updateUserInfo(Map session,UserView user);
	
	/**
	 * 
	* @Title: getAllUser
	* @Description: ��ȡ�����û�������Ϣ
	* @param requestMap �û����û�������Ϣ���Ե�ҳ��
	* @return
	* @return String    ����SystemCode
	*
	 */
	public String getAllUser(Map requestMap);
	
	/**
	 * 
	* @Title: exit
	* @Description: ע����¼
	* @param session �Ự��Χ
	* @return
	* @return String    
	*
	 */
	public String exit(Map session);

	public String searchUserByKey(Map requestMap, UserQueryVo userQueryVo);
}
