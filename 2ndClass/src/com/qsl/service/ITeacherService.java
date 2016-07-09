package com.qsl.service;

import java.util.Map;

import com.qsl.pojo.Teacher;

public interface ITeacherService {
	/**
	 * 
	* @Title: getTeacher
	* @Description: ������ʦ������ʦ��tea_nameȥ��ȡ��ʦ
	* @param requestMap ���ڱ������ݻش���ҳ��
	* @param teacher Ҫ��ѯ����ʦ��Ϣ
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String getTeacher(Map requestMap,Teacher teacher);
	
	/**
	 * 
	* @Title: addTeacher
	* @Description: ���һ����ʦ��������дtea_name��job��exp��pic
	* @param teacher ��ʦ����
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String addTeacher(Teacher teacher);
	
	/**
	 * 
	* @Title: delTeacher
	* @Description: ɾ����ʦ������tea_idɾ����ʦ
	* @param teacher Ҫɾ���Ľ�ʦ����
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String delTeacher(Teacher teacher);
	
	/**
	 * 
	* @Title: EditTeacher
	* @Description: �޸���ʦ��Ϣ��tea_name��job��exp��pic�������޸�
	* @param teacher Ҫ�޸ĵ���ʦ����
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String EditTeacher(Teacher teacher);
	
	/**
	 * ����id��ȡ��ʦ
	 * @param id ��Ҫ��ѯ��id
	 * @return
	 */
	public String getTeacherById(Map requestMap,int id);
}
