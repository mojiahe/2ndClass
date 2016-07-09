package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.User;
import com.qsl.pojo.customer.UserQueryVo;
import com.qsl.pojo.customer.UserView;

public interface UserMapper {
	/**
	 * 
	* @Title: selectUserByCondition
	* @Description: 根据条件查询用户,如果condition为null则查询所有，否则根据相应条件查询
	* @param queryVo 自定义包装类，包含查询条件condition:id、username、tel
	* @return List<User>    
	*
	 */
	public List<User> selectUserByCondition(UserQueryVo queryVo);
	
	/**
	 * 
	* @Title: insertUser
	* @Description: 添加用户
	* @param user 要添加的用户对象
	* @return int    
	*
	 */
	public int insertUser(User user);
	
	/**
	 * 
	* @Title: updateUser
	* @Description: 修改用户信息
	* @param user	要修改的用户对象
	* @return User    返回修改成功的用户对象
	*
	 */
	public void updateUser(UserView user);

	public List<User> selectUserByKey(UserQueryVo userQueryVo);
	
		
}
