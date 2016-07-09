package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Section;

public interface SectionMapper {

	/**
	 * �������е��½���Ϣ
	 * @return ���е��½���Ϣ
	 */
	public List<Section> getAllSection();
	
	/**
	 * ���ݿγ�id������ص��½���Ϣ
	 * @param cid �γ�id
	 * @return ��ص��½���Ϣ
	 */
	public List<Section> getSectionByCid(int cid);
	
	/**
	 * ����½���Ϣ
	 * @param section ��Ҫ��ӵ��½�
	 */
	public void insertSection(Section section);
	
	
	/**
	 * �����½���Ϣ
	 * @param section
	 */
	public void updateSection(Section section);
	
	public Section getSectionBySid(int sid);
}
