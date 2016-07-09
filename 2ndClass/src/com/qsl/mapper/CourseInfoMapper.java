package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.CourseInfo;

public interface CourseInfoMapper {
	
	/**
	 * 
	 * @Title: selectCourseInfo
	 * @Description: 查询课程的相关信息
	 * @param course	要查询的课程的相关信息，为null时查询全部
	 * @return List<CourseInfo>
	 *
	 */
	public List<CourseInfo> selectCourseInfo(CourseInfo courseInfo);

	/**
	 * 
	 * @Title: insertCourseInfo
	 * @Description: 添加课程的相关信息
	 * @param CourseInfo
	 *            要添加的课程的相关信息对象
	 * @return void
	 *
	 */
	public void insertCourseInfo(CourseInfo courseInfo);

	/**
	 * 
	 * @Title: updateCourseInfo
	 * @Description: 修改课程的相关信息
	 * @param CourseInfo
	 *            要修改的课程的相关信息对象
	 * @return CourseInfo 返回修改成功的课程的相关信息对象
	 *
	 */
	public void updateCourseInfo(CourseInfo courseInfo);
}
