package com.crs.lt.service;

import java.util.List;

import com.crs.lt.beans.Course;


public interface CourseServiceInterface {
	void addCourse();

	void removeCourse();
	
	Course getCourse();
	
	List<Course> getCourses();
	
	List<Course> getCoursesByCourseName(List<String> courses);
}
