package com.qsl.mapper;


import com.qsl.pojo.Manager;

public interface ManagerMapper {
	/**
	 * 
	 * @Title: selectManagerByName
	 * @Description: ���ݹ���Ա�û�����ѯ����Ա
	 * @param manager	Ҫ��ѯ�Ĺ���Ա��Ϣ
	 * @return Manager
	 *
	 */
	public Manager selectManagerByName(Manager manager);
	/**
	 * 
	 * @Title: selectManagerByTel
	 * @Description: ���ݹ���Ա�绰��ѯ����Ա
	 * @param manager	Ҫ��ѯ�Ĺ���Ա��Ϣ
	 * @return Manager
	 *
	 */
	public Manager selectManagerByTel(Manager manager);

	/**
	 * 
	 * @Title: insertManager
	 * @Description: ��ӹ���Ա
	 * @param Manager Ҫ��ӵĹ���Ա����
	 * @return void
	 *
	 */
	public void insertManager(Manager Manager);

	/**
	 * 
	 * @Title: updateManager
	 * @Description: �޸Ĺ���Ա��Ϣ
	 * @param Manager Ҫ�޸ĵĹ���Ա����
	 * @return Manager �����޸ĳɹ��Ĺ���Ա����
	 *
	 */
	public void updateManager(Manager Manager);
}
