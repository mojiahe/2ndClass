package com.qsl.service;

import java.util.List;
import java.util.Map;

import com.qsl.pojo.Section;

public interface ISectionService {

	/**
	 * 
	* @Title: getAllSection
	* @Description: ���������½���Ϣ
	* @param requestMap ���ڱ������ݻش���ҳ��
	* @return int    ���ص�SystemCode
	*
	 */
	public String getAllSection(Map requestMap);
	
	/**
	 * 
	* @Title: getSectionByCid
	* @Description: ���ݿγ�id ��������½���Ϣ
	* @param requestMap ���ڱ������ݻش���ҳ��
	* @param cid ��Ҫ��ѯ�Ŀγ�id
	* @return int    ���ص�SystemCode
	*
	 */
	public String  getSectionByCid(Map requestMap,int cid);
	
	
	/**
	 * ����½���Ϣ
	 * @param section ��Ҫ��ӵ��½�
	 */
	public String insertSection(Section section);
	
	/**
	 * ɾ���½���Ϣ
	 * @param sid ��Ҫɾ�����½�id
	 */
	public String delSection(int sid);
	
	/**
	 * �����½�
	 * @param sid
	 * @return
	 */
	public String updateSection(Section section);
	
	/**
	 * ������Ҫ�޸ĵ��½�
	 * @param sid
	 * @return
	 */
	public String saveEditSection(Map requestMap,int sid);
	
	/**
	 * ����cid��sid��ѯ�½���Ϣ�Ϳγ���Ϣ
	 * @param requestMap
	 * @param cid
	 * @param sid
	 * @return
	 */
	public String getSectionCourserInfoByid(Map requestMap,int cid,int sid);
	
}
