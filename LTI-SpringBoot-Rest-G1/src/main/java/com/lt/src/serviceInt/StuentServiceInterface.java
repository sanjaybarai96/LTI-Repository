package com.lt.src.serviceInt;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.lt.src.bean.Student;
import com.lt.src.bean.User;

import net.minidev.json.JSONObject;


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
	public ResponseEntity courseRegistration(JSONObject jsonBody);
	
	/**
	 * 
	 */
	public ResponseEntity dropCourse(JSONObject jsonBody);
	/**
	 * @param course2
	 */
	/**
	 * @param jsonBody
	 */
	public ResponseEntity addCourse(JSONObject jsonBody);
	
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
