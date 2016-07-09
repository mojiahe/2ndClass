package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Course;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.pojo.customer.CourseQueryVo;

public interface CourseMapper {
	/**
	 * 
	 * @Title: selectCourse
	 * @Description: 查询课程
	 * @param course	要查询的课程信息，为null时查询全部
	 * @return List<CourseCustom>
	 *
	 */
	public List<CourseCustom> selectCourse(CourseQueryVo queryVo);

	/**
	 * 
	 * @Title: selectCourseAndTeacher
	 * @Description: 查询课程延迟加载方式关联查询老师信息
	 * @param course	要查询的课程信息，为null时查询全部
	 * @return List<CourseCustom>
	 *
	 */
	public List<CourseCustom> selectCourseAndTeacher(Course course);

	/**
	 * 
	 * @Title: insertCourse
	 * @Description: 添加课程
	 * @param Course
	 *            要添加的课程对象
	 * @return void
	 *
	 */
	public void insertCourse(Course course);

	/**
	 * 
	 * @Title: updateCourse
	 * @Description: 修改课程信息
	 * @param Course
	 *            要修改的课程对象
	 * @return Course 返回修改成功的课程对象
	 *
	 */
	public void updateCourse(Course course);
	
	
	public Course selectCourseById(int cid);
	
	

	
}
