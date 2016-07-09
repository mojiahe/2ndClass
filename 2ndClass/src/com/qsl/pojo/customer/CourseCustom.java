package com.qsl.pojo.customer;

import com.qsl.pojo.Course;
import com.qsl.pojo.CourseInfo;
import com.qsl.pojo.Section;
import com.qsl.pojo.Teacher;
import com.qsl.pojo.Type;

public class CourseCustom extends Course {

	private Teacher teacher;
	private CourseInfo courseInfo;
	private Type parType;
	private Type subType;
	private Section section;
	
	

	

	/**
	 * @return parType
	 */
	public Type getParType() {
		return parType;
	}

	/**
	 * @param parType Ҫ���õ� parType
	 */
	public void setParType(Type parType) {
		this.parType = parType;
	}

	/**
	 * @return subType
	 */
	public Type getSubType() {
		return subType;
	}

	/**
	 * @param subType Ҫ���õ� subType
	 */
	public void setSubType(Type subType) {
		this.subType = subType;
	}

	/**
	 * @return section
	 */
	public Section getSection() {
		return section;
	}

	/**
	 * @param section Ҫ���õ� section
	 */
	public void setSection(Section section) {
		this.section = section;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	

	/**
	 * @return teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher Ҫ���õ� teacher
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "CourseCustom [teacher=" + teacher + ", courseInfo="
				+ courseInfo + ", parType=" + parType + ", subType=" + subType
				+ ", section=" + section + "]";
	}

	

	
	
	
	
}
