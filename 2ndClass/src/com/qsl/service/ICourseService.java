package com.qsl.service;

import java.util.Map;

import com.qsl.pojo.Type;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.pojo.customer.CourseQueryVo;

public interface ICourseService {
	/**
	 * 
	* @Title: getCourseOnHome
	* @Description: ���Ұ˸������ŵĵĿγ���Ϣ�ŵ���ҳ��
	* @param requestMap ������ҳ�洫�Ͳ��ҵ��Ŀγ���Ϣ
	* @return String    ����SystemCode
	*
	 */
	public String getCourseOnHome(Map requestMap);
	
	/**
	 * 
	* @Title: getAllCourseAndInfoByType
	* @Description: ���Ҹ����������пγ̼���ʦ��Ϣ�������Ϣ
	* @param requestMap ������ҳ�洫�Ͳ��ҵ��Ŀγ���Ϣ
	* @param type �����Ŀγ����
	* @return String    ����SystemCode 
	*
	 */
	public String getAllCourseAndInfoByType(Map requestMap,Type type);
	
	/**
	 * 
	* @Title: uploadCourse
	* @Description: �ϴ��¿γ̣����ѿγ̵Ľ�ʦ��Ϣ�������Ϣ����
	* @param courseCustom Ҫ�ϴ��Ŀγ���Ϣ�������Ϣ
	* @return String ����SystemCode    
	*
	 */
	public String uploadCourse(CourseCustom courseCustom);
	
	/**
	 * 
	* @Title: removeCourse
	* @Description: ���ݿγ���ɾ��һ�ſγ̼�����ſγ���ص���Ϣ
	* @param courseCustom Ҫɾ���Ŀγ���
	* @return String ����SystemCode    
	*
	 */
	public String removeCourse(CourseCustom courseCustom);
	
	/**
	 * 
	* @Title: modifyCourseInfo
	* @Description: �޸Ŀγ̼����ʦ��Ϣ�������Ϣ
	* @param courseCustom Ҫ�޸ĵĿγ̼�����Ϣ
	* @return 
	* @return String    ����SystemCode
	*
	 */
	public String modifyCourseInfo(CourseCustom courseCustom);
	
	/**
	 * ���ݿγ�����ѯ�γ�
	 * @param requestMap
	 * @return
	 */
	public String getCourseByName(Map requestMap, CourseQueryVo course); 
	
	public String getCourseById(Map requestMap, CourseQueryVo course);
	
}
