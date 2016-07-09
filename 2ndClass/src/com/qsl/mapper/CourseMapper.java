package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Course;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.pojo.customer.CourseQueryVo;

public interface CourseMapper {
	/**
	 * 
	 * @Title: selectCourse
	 * @Description: ��ѯ�γ�
	 * @param course	Ҫ��ѯ�Ŀγ���Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<CourseCustom>
	 *
	 */
	public List<CourseCustom> selectCourse(CourseQueryVo queryVo);

	/**
	 * 
	 * @Title: selectCourseAndTeacher
	 * @Description: ��ѯ�γ��ӳټ��ط�ʽ������ѯ��ʦ��Ϣ
	 * @param course	Ҫ��ѯ�Ŀγ���Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<CourseCustom>
	 *
	 */
	public List<CourseCustom> selectCourseAndTeacher(Course course);

	/**
	 * 
	 * @Title: insertCourse
	 * @Description: ��ӿγ�
	 * @param Course
	 *            Ҫ��ӵĿγ̶���
	 * @return void
	 *
	 */
	public void insertCourse(Course course);

	/**
	 * 
	 * @Title: updateCourse
	 * @Description: �޸Ŀγ���Ϣ
	 * @param Course
	 *            Ҫ�޸ĵĿγ̶���
	 * @return Course �����޸ĳɹ��Ŀγ̶���
	 *
	 */
	public void updateCourse(Course course);
	
	
	public Course selectCourseById(int cid);
	
	

	
}
