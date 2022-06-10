package com.lt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lt.entity.StudentRegistered;
import com.lt.service.StudentService;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * Student registering course
	 * @param jsonBody
	 * @return
	 */
	@RequestMapping(value="/courseReg",method = RequestMethod.POST)
	@ResponseStatus
	public ResponseEntity<?> courseRegistration(@RequestBody StudentRegistered sdntregisteredCourse) {
		return studentService.courseRegistration(sdntregisteredCourse);
	}
	
	/**
	 * TO view all course
	 * @return
	 */
	@RequestMapping(value="/viewCatalog",method = RequestMethod.GET)
	public ResponseEntity<?> getAllCourse() {
		return studentService.getCourses();
	}
	
	/**
	 * Get course which student has selected
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getCourse/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getCourseByStudentId(@PathVariable("id") long id) {
		return studentService.getStudentCourse(id);
	}
	
	/**
	 * Student select course from courses
	 * @param jsonBody
	 * @return
	 */
	@RequestMapping(value="/addCourse",method = RequestMethod.POST)
	public ResponseEntity<?> addCourse(@RequestBody JSONObject jsonBody) {
		return studentService.addCourse(jsonBody);
	}
	
	/**
	 * Student removing the course from the selected course
	 * @param jsonBody
	 * @return
	 */
	@RequestMapping(value="/dropCourse",method = RequestMethod.POST)
	public ResponseEntity<?> dropCourse(@RequestBody JSONObject jsonBody) {
		return studentService.dropCourse(jsonBody);
	}
}
