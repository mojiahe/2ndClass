package com.qsl.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.mapper.CourseInfoMapper;
import com.qsl.mapper.CourseMapper;
import com.qsl.mapper.SectionMapper;
import com.qsl.mapper.TeacherMapper;
import com.qsl.mapper.TypeMapper;
import com.qsl.pojo.Section;
import com.qsl.pojo.Teacher;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.service.ISectionService;
import com.qsl.status.SystemCode;

public class SectionServiceImpl implements ISectionService {

	//注解
	@Autowired
	private SectionMapper sectionMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	
	
	
	@Override
	public String getAllSection(Map requestMap) {
		
		List<Section> list=sectionMapper.getAllSection();
		
		if(null==list||0==list.size()){
			return SystemCode.ERROR;
		}
		
		requestMap.put("sectionlist", list);
		
		return SystemCode.SUCCESS;
		

	}

	@Override
	public String getSectionByCid(Map requestMap, int cid) {
		
		List<Section> list=sectionMapper.getSectionByCid(cid);
		if(null==list|| 0==list.size()){
			return SystemCode.ERROR;
		}
		
		requestMap.put("sectionlist", list);
		
		
		//获取对应的courseCustom信息
		List<CourseCustom> courselist = courseMapper.selectCourse(null);
		
		List<CourseCustom> courses = new ArrayList<CourseCustom>();
		
		if (courselist.isEmpty()) {
			return SystemCode.ERROR;
		}
		
		
		for (int i = 0; i < courselist.size(); i++) {
			CourseCustom courseCustom = courselist.get(i);
			Teacher teacher = teacherMapper.selectTeacherById(courseCustom
					.getCourseInfo().getTea_id());
			courseCustom.setTeacher(teacher);
			courses.add(courseCustom);
		}
		//保存相应的courseCustom信息
		for (int i = 0; i < courses.size(); i++) {
			if(cid==courses.get(i).getCid()){
				requestMap.put("courseCustom", courses.get(i));
			}
		}
		
		return SystemCode.SUCCESS;
	}

	@Override
	public String insertSection(Section section) {
		Section sel_section=sectionMapper.getSectionBySid(section.getSid());
		if(null!=sel_section){
			return SystemCode.ERROR;
		}
		
		section.setIs_del(0);
		sectionMapper.insertSection(section);
		
		return SystemCode.SUCCESS;
		
	}

	@Override
	public String delSection(int sid) {
		
		Section section=sectionMapper.getSectionBySid(sid);
		if(null==section){
			return SystemCode.ERROR;
		}
		Section del_section=new Section();
		del_section.setSid(sid);
		del_section.setIs_del(1);
		sectionMapper.updateSection(del_section);
		
		return SystemCode.SUCCESS;
		
		
		
	}

	@Override
	public String updateSection(Section section) {
		
		Section sele_section=sectionMapper.getSectionBySid(section.getSid());
        if(null==sele_section){
        	return SystemCode.ERROR;
        }
        sectionMapper.updateSection(section);
		
		return SystemCode.SUCCESS;
        
        
	}

	@Override
	public String saveEditSection(Map requestMap,int sid) {
		
		Section sele_section=sectionMapper.getSectionBySid(sid);
        if(null==sele_section){
        	return SystemCode.ERROR;
        }
        
        requestMap.put("selectSection", sele_section);
		
		return SystemCode.SUCCESS;
	}

	@Override
	public String getSectionCourserInfoByid(Map requestMap, int cid, int sid) {
		
		List<Section> list=sectionMapper.getSectionByCid(cid);
		if(null==list|| 0==list.size()){
			return SystemCode.ERROR;
		}
		requestMap.put("sectionlist", list);
		
		for (int i = 0; i < list.size(); i++) {
			if(sid==list.get(i).getSid()){
				requestMap.put("onesection", list.get(i));
			}
			
		}

		//获取对应的courseCustom信息
		List<CourseCustom> courselist = courseMapper.selectCourse(null);
		
		List<CourseCustom> courses = new ArrayList<CourseCustom>();
		
		if (courselist.isEmpty()) {
			return SystemCode.ERROR;
		}
		
		
		for (int i = 0; i < courselist.size(); i++) {
			CourseCustom courseCustom = courselist.get(i);
			Teacher teacher = teacherMapper.selectTeacherById(courseCustom
					.getCourseInfo().getTea_id());
			courseCustom.setTeacher(teacher);
			courses.add(courseCustom);
		}
		//保存相应的courseCustom信息
		for (int i = 0; i < courses.size(); i++) {
			if(cid==courses.get(i).getCid()){
				requestMap.put("courseCustom", courses.get(i));
			}
		}
		
		return SystemCode.SUCCESS;
	}

}
