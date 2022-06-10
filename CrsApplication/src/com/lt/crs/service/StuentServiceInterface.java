/**
 * 
 */
package com.lt.crs.service;

import java.util.List;
import java.util.UUID;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;

/**
 * @author user217
 *
 */
/**
 * @author user215
 *
 */
public interface StuentServiceInterface {

	//	List<Student> getAllStudents();
	List<Student> getStudentsByCourseName(List<String> course);
	/**
	 * @param name
	 */
	public void courseRegistration(User user);
	
	/**
	 * 
	 */
	public void dropCourse(UUID userId);
	/**
	 * @param course2
	 */
	/**
	 * @param course2
	 */
	public void addCourse(UUID userId);
	
	/**
	 * view grades
	 */
	public void viewGrade();

	
	/**
	 * adding student
	 * @param student
	 */
	public void addStudent(Student student);
	
	public Student getStudentById(UUID userId);
}
