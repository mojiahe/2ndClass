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
		// 1.创建查询条件
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("username");
		queryVo.setUsername(user.getUsername());
		// 2.根据输入的用户名来查询数据库中的信息
		List<User> userList = userMapper.selectUserByCondition(queryVo);
		// 3.判断是否为空
		if (userList.size() == 0) {
			return SystemCode.NOT_SUCH_USER;
		}
		// 4.判断密码是否正确
		if (!user.getPassword().equals(userList.get(0).getPassword())) {
			return SystemCode.ERROR_PWD;
		}
		// 5.验证成功，保存到session
		session.put("user", userList.get(0));
		session.put("role", "user");

		return SystemCode.SUCCESS;
	}

	@Override
	public String register(Map session, User user) {
		// 1.创建查询条件，查询是否存在相同的用户名
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("username");
		queryVo.setUsername(user.getUsername());
		List<User> users = userMapper.selectUserByCondition(queryVo);

		// 2.如果存在，则返回已存在
		if (!users.isEmpty()) {
			return SystemCode.EXIST_USER;
		}
		// 3.查询手机号码是否存在
		queryVo.setCondition("tel");
		queryVo.setTel(user.getTel());

		users = userMapper.selectUserByCondition(queryVo);
		if (!users.isEmpty()) {
			return SystemCode.EXIST_TEL;
		}
		// 4.验证成功，插入数据库
		int i = userMapper.insertUser(user);
		
		// 5.验证成功，保存到session
		session.put("user", user);
		session.put("role", "user");
		return SystemCode.SUCCESS;
	}

	@Override
	public String findUserPwd(UserView user) {
		// 1.创建查询条件，查询是否存在用户名
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("username");
		queryVo.setUsername(user.getUsername());
		List<User> users = userMapper.selectUserByCondition(queryVo);

		// 2.如果不存在，则返回
		if (users.isEmpty()) {
			return SystemCode.NOT_SUCH_USER;
		}

		// 3.如果存在，则判断手机号是否一致
		if (!user.getTel().equals(users.get(0).getTel())) {
			return SystemCode.ERROR_TEL;
		}

		// 4.验证成功
		return SystemCode.SUCCESS;
	}

	@Override
	public String updateUserInfo(Map session, UserView user) {
		User login_user = (User) session.get("user");

		// 1.更新用户数据库信息

		if (user.getUid() == 0) {
			user.setUid(login_user.getUid());
		}

		// 2.判断页面是否上传了头像到服务器
		if (user.getFile() != null) {
			// 2.1把文件上传到服务器硬盘
			Boolean result = FileOperation.fileUpload(user.getFile(), user.getFileFileName(),
					user.getFileContentType());

			if (result == Boolean.FALSE) {
				return SystemCode.ERROR;
			}

			// 2.2保存上传文件的名称到数据集
			user.setPic(user.getFile().getName());
			user.setFile(null);
		}

		// 3.判断用户是否进行了修改密码
		if (user.getOldPwd() != null) {
			// 3.1判断输入的密码和原来的密码是否一致
			if (!login_user.getPassword().equals(user.getOldPwd())) {
				return SystemCode.ERROR_PWD;
			}
			// 3.2更新旧密码
			user.setPassword(user.getNewPwd());
		}
		userMapper.updateUser(user);

		// 2.更新页面用户信息
		UserQueryVo queryVo = new UserQueryVo();
		queryVo.setCondition("id");
		queryVo.setUid(user.getUid());
		List<User> u = userMapper.selectUserByCondition(queryVo);

		//3.判断是管理员操作还是用户操作
		String role = (String) session.get("role");
		if ("user".equals(role)) {
			// 3.1把用户信息保存到session中
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
		// 1.查询所有用户
		List<User> users = userMapper.selectUserByCondition(null);

		// 2.如果没有用户，则返回错误
		if (users.isEmpty()) {
			return SystemCode.NOT_SUCH_USER;
		}

		// 3.把用户信息保存到request域中
		requestMap.put("users", users);
		return SystemCode.SUCCESS;
	}

	@Override
	public String exit(Map session) {
		// 1.清空session的数据
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
