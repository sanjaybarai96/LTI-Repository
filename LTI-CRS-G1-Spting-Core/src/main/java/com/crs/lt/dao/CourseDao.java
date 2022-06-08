package com.crs.lt.dao;

import java.util.List;

import com.crs.lt.beans.Course;


public interface CourseDao {
	void saveCourse(Course course);

	List<Course> getAllCourse();
	
	List<Course> getCourseByInstructor(String instructorName);

	List<String> getAllBranchesCourses();
	
	List<Course> getCourseByCourseName(List<String> courses);
}
