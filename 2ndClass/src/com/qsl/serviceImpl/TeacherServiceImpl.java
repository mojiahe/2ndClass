package com.qsl.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.mapper.TeacherMapper;
import com.qsl.pojo.Teacher;
import com.qsl.service.ITeacherService;
import com.qsl.status.SystemCode;

public class TeacherServiceImpl implements ITeacherService {

	//×¢Èë
	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public String getTeacher(Map requestMap, Teacher teacher) {
		
		List<Teacher> list=teacherMapper.selectTeacherByCondition(teacher);
		if(0==list.size()){
			return SystemCode.ERROR;
		}
	    System.out.println(list.size());
		requestMap.put("teacherlist", list);
		return SystemCode.SUCCESS;
	}

	
	
	
	
	@Override
	public String addTeacher(Teacher teacher) {
		
	    
		Teacher result_tea=teacherMapper.selectTeacherByTeacherName(teacher.getTea_name());
		
		
		if(null==result_tea){
			teacherMapper.insertTeacher(teacher);
			
			return SystemCode.SUCCESS;
		}
		
		return SystemCode.EXIST_TEACHER;
		
		
		
	}

	@Override
	public String delTeacher(Teacher teacher) {
		
		teacher.setIs_del(1);
	    Teacher result=teacherMapper.selectTeacherById(teacher.getTea_id());
		System.out.println(result);
		if(null!=result){
			
			teacherMapper.updateTeacher(teacher);
			return SystemCode.SUCCESS;
		}
		return SystemCode.NOT_SUCH_TEACHER;
	}

	@Override
	public String EditTeacher(Teacher teacher) {
		
		System.out.println(teacher.getTea_id());
	    Teacher result=teacherMapper.selectTeacherById(teacher.getTea_id());
		
		if(null!=result){
			
			teacherMapper.updateTeacher(teacher);
			return SystemCode.SUCCESS;
		}
		return SystemCode.NOT_SUCH_TEACHER;
	}





	@Override
	public String getTeacherById(Map requestMap, int id) {
		
		Teacher teacher=teacherMapper.selectTeacherById(id);
		if(null==teacher){
			return SystemCode.ERROR;
		}
		
		requestMap.put("selectteacher", teacher);
		
		return SystemCode.SUCCESS;
	}





	

}
