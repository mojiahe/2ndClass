package com.qsl.service;

import java.util.Map;

import com.qsl.pojo.Type;

public interface ITypeService {
	/**
	 * 
	* @Title: getType
	* @Description: 用类别名去获取类别
	* @param requestMap 用于保存数据回传到页面
	* @param type 要查询的类别信息
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String selectById(Map requestMap,Type type);
	/**
	 * 
	* @Title: getType
	* @Description: 用类别名去获取类别
	* @param requestMap 用于保存数据回传到页面
	* @param type 要查询的类别信息
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String getType(Map requestMap,Type type);
	
	/**
	 * 
	* @Title: addType
	* @Description: 添加一类别
	* @param type 类别对象
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String addType(Type type);
	
	/**
	 * 
	* @Title: delType
	* @Description: 删除一类别
	* @param type 要删除的类别对象
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String delType(Type type);
	
	/**
	 * 
	* @Title: EditType
	* @Description: 修改类别信息
	* @param type 要修改的类别对象
	* @return
	* @return int    返回的SystemCode
	*
	 */
	public String EditType(Type type);
}
