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
	* @Description: 用户登录。根据用户输入的username和password来进行登录
	* @param user 存储用户信息
	* @param session 会话信息，用于保存登录成功的用户信息
	* @return
	* @return String   返回相应状态码LoginCode 
	*
	 */
	public String login(Map session,User user);
	
	/**
	 * 
 	* @Title: register
	* @Description: 用户注册。用户填写username,password,tel来完成注册
	* @param user 用户的注册信息
	* @param session 会话信息，用于保存注册成功的用户信息
	* @return String  返回相应状态码SystemCode 
	*
	 */
	public String register(Map session,User user);

	/**
	 * 
	* @Title: findUserPwd
	* @Description: 找回密码。首先根据用户名和电话查找用户，如果用户存在则允许用户修改密码
	* @param 需要查找的用户信息
	* @return String  返回相应状态码SystemCode   
	*
	 */
	
	public String findUserPwd(UserView user);
	
	/**
	 * 
	* @Title: updateUserInfo
	* @Description: 更新用户信息。根据username修改用户信息
	* @param user	要更新的用户对象
	* @param session 会话信息，用于保存修改成功的用户信息
	* @return String    
	*
	 */
	public String updateUserInfo(Map session,UserView user);
	
	/**
	 * 
	* @Title: getAllUser
	* @Description: 获取所有用户及其信息
	* @param requestMap 用户把用户及其信息回显到页面
	* @return
	* @return String    返回SystemCode
	*
	 */
	public String getAllUser(Map requestMap);
	
	/**
	 * 
	* @Title: exit
	* @Description: 注销登录
	* @param session 会话范围
	* @return
	* @return String    
	*
	 */
	public String exit(Map session);

	public String searchUserByKey(Map requestMap, UserQueryVo userQueryVo);
}
