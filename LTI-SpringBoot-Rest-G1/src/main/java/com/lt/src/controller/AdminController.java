/**
 * 
 */
package com.lt.src.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.constant.Role;
import com.lt.src.bean.Course;
import com.lt.src.bean.Professor;
import com.lt.src.bean.User;
import com.lt.src.serviceImpl.AdminService;
import com.lt.src.serviceImpl.CourseService;
import com.lt.src.serviceImpl.ProfessorService;
import com.lt.src.serviceImpl.UserService;

/**
 * @author user204
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value="/addCourse",method = RequestMethod.POST)
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {

		courseService.addCourse(course);

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/removeCourse/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> removeCourse(@PathVariable("id") String id) {
		if (("").equals(courseService.removeCourse(id))) {
			return new ResponseEntity<String>("No Course found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>(id, HttpStatus.OK);

	}
	
	@RequestMapping(value="/addProfessor",method = RequestMethod.POST)
	public ResponseEntity<User> addProfessor(@RequestBody User user) {

		user.setPassword("Admin@123");
		userService.createUser(user, 1, Role.Professor);
		
		professorService.addProfessor(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value="/studentAproval",method = RequestMethod.GET)
	public ResponseEntity<?> studentAproval() {

		List<User> user = adminService.getStudentList();
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentAproval/{id}",method = RequestMethod.PUT)
	public ResponseEntity<UUID> studentAproval(@PathVariable UUID id) {

		UUID status = adminService.approveStudents(id);

		if (null == status) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UUID>(id, HttpStatus.OK);
	}
}
