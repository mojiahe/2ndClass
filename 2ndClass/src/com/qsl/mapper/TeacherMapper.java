package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Teacher;

public interface TeacherMapper {
	/**
	 * 
	 * @Title: selectTeacherByCondition
	 * @Description: ����������ѯ��ʦ
	 * @param Teacher	Ҫ��ѯ����ʦ��Ϣ
	 * @return List<Teacher>
	 *
	 */
	public List<Teacher> selectTeacherByCondition(Teacher teacher);

	
	
	/**
	 * 
	 * @Title: selectTeacherByTeacherName
	 * @Description: ������ʦ���ֲ�ѯ��ʦ
	 * @param name	Ҫ��ѯ����ʦ����
	 * @return Teacher
	 *
	 */
	public Teacher selectTeacherByTeacherName(String name);
	
	/**
	 * 
	 * @Title: selecselectTeacherById
	 * @Description: ������ʦid��ѯ��ʦ
	 * @param name	Ҫ��ѯ����ʦid
	 * @return Teacher
	 *
	 */
	
	public Teacher selectTeacherById(int id);
	/**
	 * 
	 * @Title: insertTeacher
	 * @Description: �����ʦ
	 * @param Teacher
	 *            Ҫ��ӵ���ʦ����
	 * @return void
	 *
	 */
	public void insertTeacher(Teacher Teacher);

	/**
	 * 
	 * @Title: updateTeacher
	 * @Description: �޸���ʦ��Ϣ
	 * @param Teacher
	 *            Ҫ�޸ĵ���ʦ����
	 * @return void
	 *
	 */
	public void updateTeacher(Teacher teacher);
}
