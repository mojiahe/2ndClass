package com.qsl.mapper;


import com.qsl.pojo.Manager;

public interface ManagerMapper {
	/**
	 * 
	 * @Title: selectManagerByName
	 * @Description: 根据管理员用户名查询管理员
	 * @param manager	要查询的管理员信息
	 * @return Manager
	 *
	 */
	public Manager selectManagerByName(Manager manager);
	/**
	 * 
	 * @Title: selectManagerByTel
	 * @Description: 根据管理员电话查询管理员
	 * @param manager	要查询的管理员信息
	 * @return Manager
	 *
	 */
	public Manager selectManagerByTel(Manager manager);

	/**
	 * 
	 * @Title: insertManager
	 * @Description: 添加管理员
	 * @param Manager 要添加的管理员对象
	 * @return void
	 *
	 */
	public void insertManager(Manager Manager);

	/**
	 * 
	 * @Title: updateManager
	 * @Description: 修改管理员信息
	 * @param Manager 要修改的管理员对象
	 * @return Manager 返回修改成功的管理员对象
	 *
	 */
	public void updateManager(Manager Manager);
}
