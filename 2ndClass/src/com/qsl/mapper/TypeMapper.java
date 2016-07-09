package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Type;

public interface TypeMapper {
	/**
	 * 
	 * @Title: selectTypeByName
	 * @Description: 查询课程关联查询老师信息
	 * @param course	要查询的课程信息，为null时查询全部
	 * @return List<Type>
	 *
	 */
	public List<Type> selectType(Type type);

	/**
	 * 
	 * @Title: insertType
	 * @Description: 添加类别
	 * @param Type
	 *            要添加的类别对象
	 * @return void
	 *
	 */
	public void insertType(Type type);

	/**
	 * 
	 * @Title: updateType
	 * @Description: 修改类别信息
	 * @param Type
	 *            要修改的类别对象
	 * @return Type 返回修改成功的类别对象
	 *
	 */
	public void updateType(Type type);
	
	/**
	 * 
	 * @Title: select
	 * @Description: 按名字查询课程类型
	 * @param course	要查询的课程信息，为null时查询全部
	 * @return List<Type>
	 *
	 */
	public List<Type> select(Type type);//按名字查询类型
	/**
	 * 
	 * @Title: selectType
	 * @Description: 按名字查询课程类型
	 * @param course	要查询的课程信息，为null时查询全部
	 * @return List<Type>
	 *
	 */
	public Type selectType(String type);

	/**
	 * 
	 * @Title: selectById
	 * @Description: 按Id查询课程类型
	 * @param course	要查询的课程信息，为null时查询全部
	 * @return List<Type>
	 *
	 */
	
	public List<Type> selectById(Type type);
}
