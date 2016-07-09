package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.User;
import com.qsl.pojo.customer.UserQueryVo;
import com.qsl.pojo.customer.UserView;

public interface UserMapper {
	/**
	 * 
	* @Title: selectUserByCondition
	* @Description: ����������ѯ�û�,���conditionΪnull���ѯ���У����������Ӧ������ѯ
	* @param queryVo �Զ����װ�࣬������ѯ����condition:id��username��tel
	* @return List<User>    
	*
	 */
	public List<User> selectUserByCondition(UserQueryVo queryVo);
	
	/**
	 * 
	* @Title: insertUser
	* @Description: ����û�
	* @param user Ҫ��ӵ��û�����
	* @return int    
	*
	 */
	public int insertUser(User user);
	
	/**
	 * 
	* @Title: updateUser
	* @Description: �޸��û���Ϣ
	* @param user	Ҫ�޸ĵ��û�����
	* @return User    �����޸ĳɹ����û�����
	*
	 */
	public void updateUser(UserView user);

	public List<User> selectUserByKey(UserQueryVo userQueryVo);
	
		
}
