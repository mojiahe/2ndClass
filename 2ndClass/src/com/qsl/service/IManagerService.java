package com.qsl.service;

import java.util.Map;
import com.qsl.pojo.Manager;
import com.qsl.pojo.NewManager;

public interface IManagerService {
	/**
	 * 
	 * @Title: login
	 * @Description: 管理员登录。管理员输入mname,password来进行登录
	 * @param manager
	 *            存储管理员信息
	 * @param session
	 *            会话信息
	 * @return manager 返回登录成功的管理员对象
	 * @return
	 * @return String 返回相应状态码SystemCode
	 *
	 */
	public String login(Map session, Manager manager);

	/**
	 * 
	 * @Title: add
	 * @Description: 新增管理员。要求必须填写mname,password,tel
	 * @param manager
	 *            管理员的信息
	 * @param session
	 * @return String 返回相应状态码SystemCode
	 *
	 */
	public String add(Map session, Manager manager);

	/**
	 * 
	 * @Title: findManagerPwd
	 * @Description: 找回密码。根据用户名和电话查找管理员，如果存在管理员则允许修改密码
	 * @param 需要查找
	 * @return String 返回相应状态码SystemCode
	 *
	 */

	public String findManagerPwd(Manager manager);

	/**
	 * 
	 * @Title: updateManagerInfo
	 * @Description: 更新管理员。根据mname修改管理员信息
	 * @param manager
	 *            存储要修改的管理员信息
	 * @param session 用于更新session中保存的管理员信息
	 * @return String
	 *
	 */
	public String updateManagerPwd(Map session, NewManager manager);
	/**
	 * 
	 * @Title: updateManagerPwd
	 * @Description: 更新管理员密码。根据mname修改管理员信息
	 * @param manager
	 *            存储要修改的管理员信息
	 * @param session 用于更新session中保存的管理员信息
	 * @return String
	 *
	 */
	public String updateManagerInfo(Map session, NewManager manager);
	/**
	 * 
	 * @Title: exit
	 * @Description: 注销
	 * @param session 
	 * @return String
	 *
	 */
	public String exit(Map session);

}
