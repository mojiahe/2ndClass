package com.qsl.service;

import java.util.Map;
import com.qsl.pojo.Manager;
import com.qsl.pojo.NewManager;

public interface IManagerService {
	/**
	 * 
	 * @Title: login
	 * @Description: ����Ա��¼������Ա����mname,password�����е�¼
	 * @param manager
	 *            �洢����Ա��Ϣ
	 * @param session
	 *            �Ự��Ϣ
	 * @return manager ���ص�¼�ɹ��Ĺ���Ա����
	 * @return
	 * @return String ������Ӧ״̬��SystemCode
	 *
	 */
	public String login(Map session, Manager manager);

	/**
	 * 
	 * @Title: add
	 * @Description: ��������Ա��Ҫ�������дmname,password,tel
	 * @param manager
	 *            ����Ա����Ϣ
	 * @param session
	 * @return String ������Ӧ״̬��SystemCode
	 *
	 */
	public String add(Map session, Manager manager);

	/**
	 * 
	 * @Title: findManagerPwd
	 * @Description: �һ����롣�����û����͵绰���ҹ���Ա��������ڹ���Ա�������޸�����
	 * @param ��Ҫ����
	 * @return String ������Ӧ״̬��SystemCode
	 *
	 */

	public String findManagerPwd(Manager manager);

	/**
	 * 
	 * @Title: updateManagerInfo
	 * @Description: ���¹���Ա������mname�޸Ĺ���Ա��Ϣ
	 * @param manager
	 *            �洢Ҫ�޸ĵĹ���Ա��Ϣ
	 * @param session ���ڸ���session�б���Ĺ���Ա��Ϣ
	 * @return String
	 *
	 */
	public String updateManagerPwd(Map session, NewManager manager);
	/**
	 * 
	 * @Title: updateManagerPwd
	 * @Description: ���¹���Ա���롣����mname�޸Ĺ���Ա��Ϣ
	 * @param manager
	 *            �洢Ҫ�޸ĵĹ���Ա��Ϣ
	 * @param session ���ڸ���session�б���Ĺ���Ա��Ϣ
	 * @return String
	 *
	 */
	public String updateManagerInfo(Map session, NewManager manager);
	/**
	 * 
	 * @Title: exit
	 * @Description: ע��
	 * @param session 
	 * @return String
	 *
	 */
	public String exit(Map session);

}
