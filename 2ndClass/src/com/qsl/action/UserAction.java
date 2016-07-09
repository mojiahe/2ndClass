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
	// �ύ������file������
	private String fileFileName;

	// �ύ������file��MIME����
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
	 * �û���¼
	 */
	public void login() throws IOException {
		System.out.println(user);
		// 1.���÷�������
		response.setContentType("text/html;charset=UTF-8");

		// 2.��ȡPrintWriter����out
		PrintWriter out = response.getWriter();

		// 3.���������û���Ϣ�����û�,���ؽ��
		String result = userService.login(sessionMap, user);

		// 4.�жϷ��ؽ��
		if (result == SystemCode.NOT_SUCH_USER) {
			out.write(SystemCode.NOT_SUCH_USER);
		} else if (result == SystemCode.ERROR_PWD) {
			out.write(SystemCode.ERROR_PWD);
		} else {
			// 5.�ж��Ƿ�ѡ�˼�ס�û�
			if ("true".equals(user.getIsRemember())) {
				Cookie cookie = new Cookie("2ndClassCookie",
						user.getUsername() + "/" + user.getPassword() + "/" + user.getIsRemember());

				// ����ʧЧʱ��Ϊ7��
				cookie.setMaxAge(60 * 60 * 24 * 7); // ʹcookieʧЧ
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			out.write("success");
		}
		user = new UserView();
	}

	/*
	 * �û�ע��
	 */
	public void register() throws IOException {
		System.out.println(user);
		// 1.���÷�������
		response.setContentType("text/html;charset=UTF-8");

		// 2.��ȡPrintWriter����out
		PrintWriter out = response.getWriter();

		// 3.���������û���Ϣ�����û�,���ؽ��
		String result = userService.register(sessionMap, user);

		// 4.�жϷ��ؽ��
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
		// �ж��Ƿ�������ļ��ϴ�
		if (user.getFile() != null) {
			user.setFileContentType(fileContentType);
			user.setFileFileName(fileFileName);
		}

		String result = userService.updateUserInfo(sessionMap, user);
		// �ж��Ƿ�������޸�����
		if (result.equals(SystemCode.ERROR_PWD)) {
			requestMap.put("message", "�������");
			return "update_fail_Error_Pwd";
		}
		if (user.getOldPwd() != null && result.equals(SystemCode.SUCCESS)) {
			return "update_pwd_success";
		}
		requestMap.put("message", "�����ɹ�");
		user = new UserView();

		if (SystemCode.MANAGER_OPERATION_SUCCESS.equals(result)) {
			return "MANAGER_OPERATION_SUCCESS";
		}
		return "update_success";
	}

	/*
	 * ��ת����������
	 */
	public String personCenter() {
		return "personCenter";
	}

	/*
	 * �û�ע��
	 */
	public String exit() {
		// 1.��ջỰ��Ϣ
		sessionMap.clear();

		// 2.���cookie��Ϣ
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
	 * ���ݹؼ��ֲ�ѯ�û�
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
