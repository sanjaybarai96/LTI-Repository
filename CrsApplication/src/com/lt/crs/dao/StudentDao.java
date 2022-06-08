package com.lt.crs.dao;

import java.util.List;
import java.util.UUID;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.RegisterCourse;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;

public interface StudentDao {

//	List<Student> getAllStudents();
	List<Student> getStudentsByCourseName(List<String> course);
	/**
	 * @param name
	 */
	public void courseRegistration(RegisterCourse registerCourse);
	
	/**
	 * 
	 */
	public void dropCourse();
	/**
	 * @param course2
	 */
	/**
	 * @param course2
	 */
	public List<String> addCourse(List<String> courses);
	
	/**
	 * 
	 */
	public void viewGrade();
	Student getStudentByID(UUID userId);
	
	void updateStudent(Student student, UUID userId);
	
	void save(Student student);

}
