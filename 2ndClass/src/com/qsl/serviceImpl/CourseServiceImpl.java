package com.qsl.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.mapper.CourseInfoMapper;
import com.qsl.mapper.CourseMapper;
import com.qsl.mapper.TeacherMapper;
import com.qsl.mapper.TypeMapper;
import com.qsl.pojo.Course;
import com.qsl.pojo.CourseInfo;
import com.qsl.pojo.Teacher;
import com.qsl.pojo.Type;
import com.qsl.pojo.customer.CourseCustom;
import com.qsl.pojo.customer.CourseQueryVo;
import com.qsl.service.ICourseService;
import com.qsl.status.SystemCode;

public class CourseServiceImpl implements ICourseService {

	// 注解
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CourseInfoMapper courseInfoMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private TypeMapper typeMapper;

	@Override
	public String getCourseOnHome(Map requestMap) {
		
/*		Type type=new Type();
		type.setTname("java");
		CourseQueryVo query=new CourseQueryVo();
		query.setType(type);*/
		List<CourseCustom> courselist = courseMapper.selectCourse(null);
		System.out.println(courselist.size());
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
			System.out.println(courseCustom);
		}
		if (courselist.size()>8) {
			courses = courses.subList(0, 8);
		}
		/*for (CourseCustom courseCustom : courses) {
			System.out.println("课程名："+courseCustom.getCname()+courseCustom.getCdesc());
		}*/
		
		requestMap.put("courseslist", courses);
		return SystemCode.SUCCESS;
		
	}

	

	@Override
	public String uploadCourse(CourseCustom courseCustom) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String removeCourse(CourseCustom courseCustom) {

		CourseCustom couCustom = courseCustom;

		Course cou = courseMapper.selectCourseById(couCustom.getCid());
		List<CourseInfo> couInfo = courseInfoMapper.selectCourseInfo(couCustom
				.getCourseInfo());

		if (null != cou && 0 != couInfo.size()) {
			couCustom.setIs_del(1);
			System.out.println(couCustom.getCourseInfo().getIs_del());
			

			courseMapper.updateCourse(couCustom);
			courseInfoMapper.updateCourseInfo(couCustom.getCourseInfo());

			return SystemCode.SUCCESS;
		}
		return SystemCode.ERROR;
	}

	@Override
	public String modifyCourseInfo(CourseCustom courseCustom) {

		List<CourseInfo> result = courseInfoMapper.selectCourseInfo(courseCustom.getCourseInfo());
		Course course=courseMapper.selectCourseById(courseCustom.getCid());	

		if (0 != result.size()&&null!=course) {
			System.out.println(courseCustom.getCourseInfo());
			/*CourseInfo courseInfo=new CourseInfo();
			courseInfo.setCid(courseCustom.getCid());
			courseCustom.setCourseInfo(courseInfo);*/
			
			courseMapper.updateCourse(courseCustom);
			//courseInfoMapper.updateCourseInfo(courseCustom.getCourseInfo());
			return SystemCode.SUCCESS;
		} else {
			return SystemCode.ERROR;
		}

	}



	@Override
	public String getAllCourseAndInfoByType(Map requestMap, Type type) {
		
		//获取父分类
		Type par_type=new Type();
		par_type.setIsParent(1);
		List<Type> parType=typeMapper.selectType(par_type);
		requestMap.put("parType", parType);
        //获取子分类		
		Type sub_type=new Type();
		sub_type.setIsParent(0);
		List<Type> subType=typeMapper.selectType(sub_type);
		requestMap.put("subType", subType);
		
		
		//获取每个父类的子类集
		for (Type type2 : parType) {
			Type sub_type1=new Type();
			sub_type1.setParentid(type2.getTid());
			List<Type> subType1=typeMapper.selectType(sub_type1);
			System.out.println("subType"+type2.getTid());
			requestMap.put("subType"+type2.getTid(), subType1);
		}
		
		//获取所有课程
		List<CourseCustom> courselist = courseMapper.selectCourse(null);
		System.out.println(courselist.size());
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
			System.out.println(courseCustom);
		}
		
		requestMap.put("courseslist", courses);
		
		//获得分类的CourseCustom
		Map<String, List<CourseCustom>> map = new HashMap<String, List<CourseCustom>>();
		for (Type t : parType) {
			List<CourseCustom> cl = new ArrayList<CourseCustom>();
			for (CourseCustom courseCustom : courses) {
				if (courseCustom.getParType().getTid()==t.getTid()) {
					cl.add(courseCustom);
					
				}
				map.put(t.getTid()+"", cl);
				
				
			}
			
		}
		/*System.out.println(map.keySet().toString());
		for (Integer key:map.keySet()) {
			
			System.out.println("map size:"+map.get(key));
		}*/
		requestMap.put("coursesMap", map);
		
		return SystemCode.SUCCESS;
	}



	@Override
	public String getCourseByName(Map requestMap, CourseQueryVo course) {
		
		List<CourseCustom> courselist = courseMapper.selectCourse(course);
		System.out.println(courselist.size());
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
			System.out.println(courseCustom);
		}
		
		
		
		requestMap.put("courseslist", courses);
		return SystemCode.SUCCESS;
	}
	
	@Override
	public String getCourseById(Map requestMap, CourseQueryVo course){
		
		
		List<CourseCustom> courselist = courseMapper.selectCourse(null);
		System.out.println(courselist.size());
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
		for (int i = 0; i < courses.size(); i++) {
		if(course.getCid()==courses.get(i).getCid()){
			requestMap.put("selectcourse", courses.get(i));
			System.out.println(courses.get(i));
		}
		}
		
		return SystemCode.SUCCESS;
		
		
	}
	

}
