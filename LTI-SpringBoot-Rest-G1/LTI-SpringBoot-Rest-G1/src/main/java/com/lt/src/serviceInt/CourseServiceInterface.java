package com.lt.src.serviceInt;



import java.util.List;

import com.lt.src.bean.Course;

public interface CourseServiceInterface {

	void addCourse(Course course);

	String removeCourse(String id);
	
	Course getCourse();
	
	List<Course> getCourses();
	
	List<Course> getCoursesByCourseName(List<String> courseNames);
	
	List<Course> getCoursesByCourseCode(List<String> courseCodes);
}

