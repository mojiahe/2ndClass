package com.qsl.service;

import java.util.Map;

import com.qsl.pojo.Teacher;

public interface ITeacherService {
	/**
	 * 
	* @Title: getTeacher
	* @Description: 查找老师。用老师名tea_name去获取老师
	* @param requestMap 用于保存数据回传到页面
	* @param teacher 要查询的老师信息
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String getTeacher(Map requestMap,Teacher teacher);
	
	/**
	 * 
	* @Title: addTeacher
	* @Description: 添加一名老师。必须填写tea_name、job、exp、pic
	* @param teacher 老师对象
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String addTeacher(Teacher teacher);
	
	/**
	 * 
	* @Title: delTeacher
	* @Description: 删除教师。根据tea_id删除教师
	* @param teacher 要删除的教师对象
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String delTeacher(Teacher teacher);
	
	/**
	 * 
	* @Title: EditTeacher
	* @Description: 修改老师信息。tea_name、job、exp、pic都可以修改
	* @param teacher 要修改的老师对象
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String EditTeacher(Teacher teacher);
	
	/**
	 * 根据id获取老师
	 * @param id 需要查询的id
	 * @return
	 */
	public String getTeacherById(Map requestMap,int id);
}
