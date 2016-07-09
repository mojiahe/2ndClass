package com.qsl.service;

import java.util.Map;

import com.qsl.pojo.Type;

public interface ITypeService {
	/**
	 * 
	* @Title: getType
	* @Description: �������ȥ��ȡ���
	* @param requestMap ���ڱ������ݻش���ҳ��
	* @param type Ҫ��ѯ�������Ϣ
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String selectById(Map requestMap,Type type);
	/**
	 * 
	* @Title: getType
	* @Description: �������ȥ��ȡ���
	* @param requestMap ���ڱ������ݻش���ҳ��
	* @param type Ҫ��ѯ�������Ϣ
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String getType(Map requestMap,Type type);
	
	/**
	 * 
	* @Title: addType
	* @Description: ���һ���
	* @param type ������
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String addType(Type type);
	
	/**
	 * 
	* @Title: delType
	* @Description: ɾ��һ���
	* @param type Ҫɾ����������
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String delType(Type type);
	
	/**
	 * 
	* @Title: EditType
	* @Description: �޸������Ϣ
	* @param type Ҫ�޸ĵ�������
	* @return
	* @return int    ���ص�SystemCode
	*
	 */
	public String EditType(Type type);
}
