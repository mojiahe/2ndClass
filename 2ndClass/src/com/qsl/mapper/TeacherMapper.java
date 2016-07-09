package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Teacher;

public interface TeacherMapper {
	/**
	 * 
	 * @Title: selectTeacherByCondition
	 * @Description: 根据条件查询老师
	 * @param Teacher	要查询的老师信息
	 * @return List<Teacher>
	 *
	 */
	public List<Teacher> selectTeacherByCondition(Teacher teacher);

	
	
	/**
	 * 
	 * @Title: selectTeacherByTeacherName
	 * @Description: 根据老师名字查询老师
	 * @param name	要查询的老师名字
	 * @return Teacher
	 *
	 */
	public Teacher selectTeacherByTeacherName(String name);
	
	/**
	 * 
	 * @Title: selecselectTeacherById
	 * @Description: 根据老师id查询老师
	 * @param name	要查询的老师id
	 * @return Teacher
	 *
	 */
	
	public Teacher selectTeacherById(int id);
	/**
	 * 
	 * @Title: insertTeacher
	 * @Description: 添加老师
	 * @param Teacher
	 *            要添加的老师对象
	 * @return void
	 *
	 */
	public void insertTeacher(Teacher Teacher);

	/**
	 * 
	 * @Title: updateTeacher
	 * @Description: 修改老师信息
	 * @param Teacher
	 *            要修改的老师对象
	 * @return void
	 *
	 */
	public void updateTeacher(Teacher teacher);
}
