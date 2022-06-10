package com.lt.src.repository;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.src.bean.Course;

@Repository
public class CourseDaoImpl {

	public void saveCourse(Course course) {
		DataCollections.courses.add(course);
	}

	public String removeCourse(String id) {
		List<Course> courses =  getAllCourse();
		for (Course c : courses) {
			if (c.getCourseCode().equals(id)) {
				courses.remove(c);
				return id;
			}
		}

		return "";
	}
	

	public List<Course> getAllCourse() {
		return DataCollections.courses;
	}

	public List<Course> getCourseByInstructor(String instructorName) {
		return DataCollections.courses.stream().filter(course->course.getInstructor().equalsIgnoreCase(instructorName))
											   .collect(Collectors.toList());
	}

	public List<String> getAllBranchesCourses() {
		return DataCollections.courseBranches;
		
	}
	public List<Course> getCourseByCourseName(List<String> courses) {
		return DataCollections.courses.stream().filter(course->courses.contains(course.getName())).collect(Collectors.toList());
	}

	public List<Course> getCourseByCourseCode(List<String> courseCodes) {
		return DataCollections.courses.stream().filter(course->courseCodes.contains(course.getCourseCode())).collect(Collectors.toList());
	}

}
