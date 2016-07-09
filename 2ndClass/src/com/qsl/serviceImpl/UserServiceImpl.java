package com.qsl.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.mapper.UserMapper;
import com.qsl.pojo.User;
import com.qsl.pojo.customer.UserQueryVo;
import com.qsl.pojo.customer.UserView;
import com.qsl.service.IUserService;
import com.qsl.status.SystemCode;
import com.qsl.util.FileOperation;

public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public String login(Map session, User user) {
		// 1.������ѯ����
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("username");
		queryVo.setUsername(user.getUsername());
		// 2.����������û�������ѯ���ݿ��е���Ϣ
		List<User> userList = userMapper.selectUserByCondition(queryVo);
		// 3.�ж��Ƿ�Ϊ��
		if (userList.size() == 0) {
			return SystemCode.NOT_SUCH_USER;
		}
		// 4.�ж������Ƿ���ȷ
		if (!user.getPassword().equals(userList.get(0).getPassword())) {
			return SystemCode.ERROR_PWD;
		}
		// 5.��֤�ɹ������浽session
		session.put("user", userList.get(0));
		session.put("role", "user");

		return SystemCode.SUCCESS;
	}

	@Override
	public String register(Map session, User user) {
		// 1.������ѯ��������ѯ�Ƿ������ͬ���û���
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("username");
		queryVo.setUsername(user.getUsername());
		List<User> users = userMapper.selectUserByCondition(queryVo);

		// 2.������ڣ��򷵻��Ѵ���
		if (!users.isEmpty()) {
			return SystemCode.EXIST_USER;
		}
		// 3.��ѯ�ֻ������Ƿ����
		queryVo.setCondition("tel");
		queryVo.setTel(user.getTel());

		users = userMapper.selectUserByCondition(queryVo);
		if (!users.isEmpty()) {
			return SystemCode.EXIST_TEL;
		}
		// 4.��֤�ɹ����������ݿ�
		int i = userMapper.insertUser(user);
		
		// 5.��֤�ɹ������浽session
		session.put("user", user);
		session.put("role", "user");
		return SystemCode.SUCCESS;
	}

	@Override
	public String findUserPwd(UserView user) {
		// 1.������ѯ��������ѯ�Ƿ�����û���
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("username");
		queryVo.setUsername(user.getUsername());
		List<User> users = userMapper.selectUserByCondition(queryVo);

		// 2.��������ڣ��򷵻�
		if (users.isEmpty()) {
			return SystemCode.NOT_SUCH_USER;
		}

		// 3.������ڣ����ж��ֻ����Ƿ�һ��
		if (!user.getTel().equals(users.get(0).getTel())) {
			return SystemCode.ERROR_TEL;
		}

		// 4.��֤�ɹ�
		return SystemCode.SUCCESS;
	}

	@Override
	public String updateUserInfo(Map session, UserView user) {
		User login_user = (User) session.get("user");

		// 1.�����û����ݿ���Ϣ

		if (user.getUid() == 0) {
			user.setUid(login_user.getUid());
		}

		// 2.�ж�ҳ���Ƿ��ϴ���ͷ�񵽷�����
		if (user.getFile() != null) {
			// 2.1���ļ��ϴ���������Ӳ��
			Boolean result = FileOperation.fileUpload(user.getFile(), user.getFileFileName(),
					user.getFileContentType());

			if (result == Boolean.FALSE) {
				return SystemCode.ERROR;
			}

			// 2.2�����ϴ��ļ������Ƶ����ݼ�
			user.setPic(user.getFile().getName());
			user.setFile(null);
		}

		// 3.�ж��û��Ƿ�������޸�����
		if (user.getOldPwd() != null) {
			// 3.1�ж�����������ԭ���������Ƿ�һ��
			if (!login_user.getPassword().equals(user.getOldPwd())) {
				return SystemCode.ERROR_PWD;
			}
			// 3.2���¾�����
			user.setPassword(user.getNewPwd());
		}
		userMapper.updateUser(user);

		// 2.����ҳ���û���Ϣ
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("id");
		queryVo.setUid(user.getUid());
		List<User> u = userMapper.selectUserByCondition(queryVo);

		//3.�ж��ǹ���Ա���������û�����
		String role = (String) session.get("role");
		if ("user".equals(role)) {
			// 3.1���û���Ϣ���浽session��
			session.put("user", u.get(0));
			return SystemCode.SUCCESS;
		}
		if ("manager".equals(role)) {
			return SystemCode.MANAGER_OPERATION_SUCCESS;
		}
		return SystemCode.ERROR;

	}

	@Override
	public String getAllUser(Map requestMap) {
		// 1.��ѯ�����û�
		List<User> users = userMapper.selectUserByCondition(null);

		// 2.���û���û����򷵻ش���
		if (users.isEmpty()) {
			return SystemCode.NOT_SUCH_USER;
		}

		// 3.���û���Ϣ���浽request����
		requestMap.put("users", users);
		return SystemCode.SUCCESS;
	}

	@Override
	public String exit(Map session) {
		// 1.���session������
		session.clear();
		return SystemCode.SUCCESS;
	}

	@Override
	public String searchUserByKey(Map requestMap,UserQueryVo userQueryVo) {
		List<User> users = userMapper.selectUserByKey(userQueryVo);
		requestMap.put("users", users);
		return SystemCode.SUCCESS;
	}

}
