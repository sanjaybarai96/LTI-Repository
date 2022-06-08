/**
 * 
 */
package com.lt.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.constant.Role;
import com.lt.src.bean.Professor;
import com.lt.src.bean.User;
import com.lt.src.repository.UserDaoImpl;
import com.lt.src.serviceImpl.ProfessorService;
import com.lt.src.serviceImpl.StudentService;
import com.lt.src.serviceImpl.UserService;
import com.lt.src.serviceInt.ProfessorServiceInterface;
import com.lt.src.serviceInt.UserServiceInterface;

/**
 * @author user217
 *
 */
@RestController
public class ProfessorController {
	@Autowired
	ProfessorServiceInterface professorService;
	@Autowired
	private UserService userService; 
	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/addProfessor",method = RequestMethod.POST)
	public void addProfessor(@RequestBody User user) {
		user.setPassword("Admin@123");
		userService.createUser(user, 1, Role.Professor);
		
		professorService.addProfessor(user);
		
	}
	
	
	@RequestMapping(value="/viewEnrolledStudents" ,method = RequestMethod.POST)
	public void viewEnrolledStudents(@RequestBody User userObj) {  
		
		professorService.viewEnrolledStudents(userObj);
	}

	
	@RequestMapping(value = "/ viewCourse" , method = RequestMethod.POST)
	public void  viewCourse(@RequestBody User userObj ) {
		
		professorService.viewCourse(userObj);	
		
	}
	

}
	
	

