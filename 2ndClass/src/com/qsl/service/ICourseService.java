package com.qsl.service;

import java.util.Map;

import com.qsl.pojo.Type;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.pojo.customer.CourseQueryVo;

public interface ICourseService {
	/**
	 * 
	* @Title: getCourseOnHome
	* @Description: 查找八个最热门的的课程信息放到主页面
	* @param requestMap 用来向页面传送查找到的课程信息
	* @return String    返回SystemCode
	*
	 */
	public String getCourseOnHome(Map requestMap);
	
	/**
	 * 
	* @Title: getAllCourseAndInfoByType
	* @Description: 查找给定类别的所有课程及教师信息、相关信息
	* @param requestMap 用来向页面传送查找到的课程信息
	* @param type 给定的课程类别
	* @return String    返回SystemCode 
	*
	 */
	public String getAllCourseAndInfoByType(Map requestMap,Type type);
	
	/**
	 * 
	* @Title: uploadCourse
	* @Description: 上传新课程，并把课程的教师信息和相关信息完善
	* @param courseCustom 要上传的课程信息和相关信息
	* @return String 返回SystemCode    
	*
	 */
	public String uploadCourse(CourseCustom courseCustom);
	
	/**
	 * 
	* @Title: removeCourse
	* @Description: 根据课程名删除一门课程及与该门课程相关的信息
	* @param courseCustom 要删除的课程名
	* @return String 返回SystemCode    
	*
	 */
	public String removeCourse(CourseCustom courseCustom);
	
	/**
	 * 
	* @Title: modifyCourseInfo
	* @Description: 修改课程及其教师信息或相关信息
	* @param courseCustom 要修改的课程及其信息
	* @return 
	* @return String    返回SystemCode
	*
	 */
	public String modifyCourseInfo(CourseCustom courseCustom);
	
	/**
	 * 根据课程名查询课程
	 * @param requestMap
	 * @return
	 */
	public String getCourseByName(Map requestMap, CourseQueryVo course); 
	
	public String getCourseById(Map requestMap, CourseQueryVo course);
	
}
