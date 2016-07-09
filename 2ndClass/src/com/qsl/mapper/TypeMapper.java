package com.qsl.mapper;

import java.util.List;

import com.qsl.pojo.Type;

public interface TypeMapper {
	/**
	 * 
	 * @Title: selectTypeByName
	 * @Description: ��ѯ�γ̹�����ѯ��ʦ��Ϣ
	 * @param course	Ҫ��ѯ�Ŀγ���Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<Type>
	 *
	 */
	public List<Type> selectType(Type type);

	/**
	 * 
	 * @Title: insertType
	 * @Description: ������
	 * @param Type
	 *            Ҫ��ӵ�������
	 * @return void
	 *
	 */
	public void insertType(Type type);

	/**
	 * 
	 * @Title: updateType
	 * @Description: �޸������Ϣ
	 * @param Type
	 *            Ҫ�޸ĵ�������
	 * @return Type �����޸ĳɹ���������
	 *
	 */
	public void updateType(Type type);
	
	/**
	 * 
	 * @Title: select
	 * @Description: �����ֲ�ѯ�γ�����
	 * @param course	Ҫ��ѯ�Ŀγ���Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<Type>
	 *
	 */
	public List<Type> select(Type type);//�����ֲ�ѯ����
	/**
	 * 
	 * @Title: selectType
	 * @Description: �����ֲ�ѯ�γ�����
	 * @param course	Ҫ��ѯ�Ŀγ���Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<Type>
	 *
	 */
	public Type selectType(String type);

	/**
	 * 
	 * @Title: selectById
	 * @Description: ��Id��ѯ�γ�����
	 * @param course	Ҫ��ѯ�Ŀγ���Ϣ��Ϊnullʱ��ѯȫ��
	 * @return List<Type>
	 *
	 */
	
	public List<Type> selectById(Type type);
}
