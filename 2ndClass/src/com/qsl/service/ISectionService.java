package com.qsl.service;

import java.util.List;
import java.util.Map;

import com.qsl.pojo.Section;

public interface ISectionService {

	/**
	 * 
	* @Title: getAllSection
	* @Description: 查找所有章节信息
	* @param requestMap 用于保存数据回传到页面
	* @return int    返回的SystemCode
	*
	 */
	public String getAllSection(Map requestMap);
	
	/**
	 * 
	* @Title: getSectionByCid
	* @Description: 根据课程id 查找相关章节信息
	* @param requestMap 用于保存数据回传到页面
	* @param cid 需要查询的课程id
	* @return int    返回的SystemCode
	*
	 */
	public String  getSectionByCid(Map requestMap,int cid);
	
	
	/**
	 * 添加章节信息
	 * @param section 需要添加的章节
	 */
	public String insertSection(Section section);
	
	/**
	 * 删除章节信息
	 * @param sid 需要删除的章节id
	 */
	public String delSection(int sid);
	
	/**
	 * 跟新章节
	 * @param sid
	 * @return
	 */
	public String updateSection(Section section);
	
	/**
	 * 保存需要修改的章节
	 * @param sid
	 * @return
	 */
	public String saveEditSection(Map requestMap,int sid);
	
	/**
	 * 根据cid和sid查询章节信息和课程信息
	 * @param requestMap
	 * @param cid
	 * @param sid
	 * @return
	 */
	public String getSectionCourserInfoByid(Map requestMap,int cid,int sid);
	
}
