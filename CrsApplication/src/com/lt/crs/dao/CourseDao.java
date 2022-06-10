package com.lt.crs.dao;

import java.util.List;

import com.lt.crs.bean.Course;

public interface CourseDao {

	void saveCourse(Course course);

	List<Course> getAllCourse();
	
	List<Course> getCourseByInstructor(String instructorName);

	List<String> getAllBranchesCourses();
	
	List<Course> getCourseByCourseName(List<String> courses);
}
