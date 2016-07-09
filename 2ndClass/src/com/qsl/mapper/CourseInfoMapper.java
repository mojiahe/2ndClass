package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.CourseInfo;

public interface CourseInfoMapper {
	
	/**
	 * 
	 * @Title: selectCourseInfo
	 * @Description: ��ѯ�γ̵������Ϣ
	 * @param course	Ҫ��ѯ�Ŀγ̵������Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<CourseInfo>
	 *
	 */
	public List<CourseInfo> selectCourseInfo(CourseInfo courseInfo);

	/**
	 * 
	 * @Title: insertCourseInfo
	 * @Description: ��ӿγ̵������Ϣ
	 * @param CourseInfo
	 *            Ҫ��ӵĿγ̵������Ϣ����
	 * @return void
	 *
	 */
	public void insertCourseInfo(CourseInfo courseInfo);

	/**
	 * 
	 * @Title: updateCourseInfo
	 * @Description: �޸Ŀγ̵������Ϣ
	 * @param CourseInfo
	 *            Ҫ�޸ĵĿγ̵������Ϣ����
	 * @return CourseInfo �����޸ĳɹ��Ŀγ̵������Ϣ����
	 *
	 */
	public void updateCourseInfo(CourseInfo courseInfo);
}
