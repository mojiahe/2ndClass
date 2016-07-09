package com.qsl.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.mapper.TypeMapper;
import com.qsl.pojo.Type;
import com.qsl.service.ITypeService;
import com.qsl.status.SystemCode;

public class TypeServiceImpl implements ITypeService {

	// ×¢½â
	@Autowired
	private TypeMapper typeMapper;

	@Override
	public String getType(Map requestMap, Type type) {

		List<Type> list = typeMapper.selectType(type);
		if (null == list || 0 == list.size()) {
			return SystemCode.ERROR;
		}

		System.out.println(list.size());
		requestMap.put("typelist", list);
		return SystemCode.SUCCESS;
	}

	public String getTypeById(Map requestMap, Type type) {

		// °´id²éÑ¯

		List<Type> list = typeMapper.selectById(type);

		if (0 == list.size()) {
			return SystemCode.ERROR;
		}
		System.out.println(list);
		requestMap.put("tList", list);
		return SystemCode.SUCCESS;
	}



	@Override
	public String addType(Type type) {
		// TODO Auto-generated method stub
		Type result_type = typeMapper.selectType(type.getTname());
		if (result_type == null) {
			typeMapper.insertType(type);
			return SystemCode.SUCCESS;
		}

		return SystemCode.ERROR;
	}

	@Override
	public String delType(Type type) {
		// TODO Auto-generated method stub

		typeMapper.updateType(type);
		return SystemCode.SUCCESS;

	}

	@Override
	public String EditType(Type type) {
		// Type result_type=typeMapper.selectType(type.getTname());
		// if(result_type==null){
		typeMapper.updateType(type);
		return SystemCode.SUCCESS;
		// }
		// return SystemCode.ERROR;
	}

	@Override
	public String selectById(Map requestMap, Type type) {
		List<Type> list = typeMapper.selectById(type);
		if (list.isEmpty()) {
			return SystemCode.NOT_SUCH_TYPE;
		}
		System.out.println(list);
		requestMap.put("type", list.get(0));
		return SystemCode.SUCCESS;
	}
}
