package com.crs.lt.daoimpl;

import java.util.List;
import java.util.stream.Collectors;

import com.crs.lt.beans.Course;
import com.crs.lt.constants.DataCollections;
import com.crs.lt.dao.CourseDao;

public class CourseDaoImpl implements CourseDao{

	@Override
	public void saveCourse(Course course) {
		DataCollections.courses.add(course);
	}

	@Override
	public List<Course> getAllCourse() {
		return DataCollections.courses;
	}

	@Override
	public List<Course> getCourseByInstructor(String instructorName) {
		return DataCollections.courses.stream().filter(course->course.getInstructor().equalsIgnoreCase(instructorName))
											   .collect(Collectors.toList());
	}

	@Override
	public List<String> getAllBranchesCourses() {
		return DataCollections.courseBranches;
		
	}

	@Override
	public List<Course> getCourseByCourseName(List<String> courses) {
		return DataCollections.courses.stream().filter(course->courses.contains(course.getName())).collect(Collectors.toList());
	}

}
