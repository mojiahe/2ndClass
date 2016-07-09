package com.qsl.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.pojo.customer.UserQueryVo;
import com.qsl.pojo.customer.UserView;
import com.qsl.service.IUserService;
import com.qsl.status.SystemCode;

public class UserAction extends BaseAction {
	private UserView user;
	private UserQueryVo userQueryVo;
	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	@Autowired
	private IUserService userService;

	public UserQueryVo getUserQueryVo() {
		return userQueryVo;
	}

	public void setUserQueryVo(UserQueryVo userQueryVo) {
		this.userQueryVo = userQueryVo;
	}

	public UserView getUser() {
		return user;
	}

	public void setUser(UserView user) {
		this.user = user;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/*
	 * 用户登录
	 */
	public void login() throws IOException {
		System.out.println(user);
		// 1.设置返回类型
		response.setContentType("text/html;charset=UTF-8");

		// 2.获取PrintWriter对象out
		PrintWriter out = response.getWriter();

		// 3.根据输入用户信息查找用户,返回结果
		String result = userService.login(sessionMap, user);

		// 4.判断返回结果
		if (result == SystemCode.NOT_SUCH_USER) {
			out.write(SystemCode.NOT_SUCH_USER);
		} else if (result == SystemCode.ERROR_PWD) {
			out.write(SystemCode.ERROR_PWD);
		} else {
			// 5.判断是否勾选了记住用户
			if ("true".equals(user.getIsRemember())) {
				Cookie cookie = new Cookie("2ndClassCookie",
						user.getUsername() + "/" + user.getPassword() + "/" + user.getIsRemember());

				// 设置失效时间为7天
				cookie.setMaxAge(60 * 60 * 24 * 7); // 使cookie失效
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			out.write("success");
		}
		user = new UserView();
	}

	/*
	 * 用户注册
	 */
	public void register() throws IOException {
		System.out.println(user);
		// 1.设置返回类型
		response.setContentType("text/html;charset=UTF-8");

		// 2.获取PrintWriter对象out
		PrintWriter out = response.getWriter();

		// 3.根据输入用户信息查找用户,返回结果
		String result = userService.register(sessionMap, user);

		// 4.判断返回结果
		if (result == SystemCode.EXIST_USER) {
			out.write(SystemCode.EXIST_USER);
		} else if (result == SystemCode.EXIST_TEL) {
			out.write(SystemCode.EXIST_TEL);
		} else {
			out.write("success");
		}
		user = new UserView();
	}

	public String findPwd() {
		return "";
	}

	public String updateInfo() {
		System.out.println(user);
		// 判断是否进行了文件上传
		if (user.getFile() != null) {
			user.setFileContentType(fileContentType);
			user.setFileFileName(fileFileName);
		}

		String result = userService.updateUserInfo(sessionMap, user);
		// 判断是否进行了修改密码
		if (result.equals(SystemCode.ERROR_PWD)) {
			requestMap.put("message", "密码错误");
			return "update_fail_Error_Pwd";
		}
		if (user.getOldPwd() != null && result.equals(SystemCode.SUCCESS)) {
			return "update_pwd_success";
		}
		requestMap.put("message", "操作成功");
		user = new UserView();

		if (SystemCode.MANAGER_OPERATION_SUCCESS.equals(result)) {
			return "MANAGER_OPERATION_SUCCESS";
		}
		return "update_success";
	}

	/*
	 * 跳转到个人中心
	 */
	public String personCenter() {
		return "personCenter";
	}

	/*
	 * 用户注销
	 */
	public String exit() {
		// 1.清空会话信息
		sessionMap.clear();

		// 2.清空cookie信息
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("2ndClassCookie".equals(cookie.getName())) {
				cookie = new Cookie(cookie.getName(), "");
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		user = new UserView();
		return "exit";
	}

	/*
	 * 根据关键字查询用户
	 */
	public String queryUserByKey() {
		userService.searchUserByKey(requestMap,userQueryVo);
		System.out.println(userQueryVo.getKey());
		return "getUserByKey_success";
	}

	public String gotoUserList() {

		String result = userService.getAllUser(requestMap);
		System.out.println("ss");
		return "gotoUserList";
	}
}
