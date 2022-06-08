package com.lt.crs.service;

import java.util.List;

import com.lt.crs.bean.Course;

public interface CourseServiceInterface {

	void addCourse();

	void removeCourse();
	
	Course getCourse();
	
	List<Course> getCourses();
	
	List<Course> getCoursesByCourseName(List<String> courses);
}

