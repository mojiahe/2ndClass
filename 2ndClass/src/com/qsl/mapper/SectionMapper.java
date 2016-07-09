package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Section;

public interface SectionMapper {

	/**
	 * 查找所有的章节信息
	 * @return 所有的章节信息
	 */
	public List<Section> getAllSection();
	
	/**
	 * 根据课程id查找相关的章节信息
	 * @param cid 课程id
	 * @return 相关的章节信息
	 */
	public List<Section> getSectionByCid(int cid);
	
	/**
	 * 添加章节信息
	 * @param section 需要添加的章节
	 */
	public void insertSection(Section section);
	
	
	/**
	 * 跟新章节信息
	 * @param section
	 */
	public void updateSection(Section section);
	
	public Section getSectionBySid(int sid);
}
