/**
 * 
 */
package com.lt.src.controller;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.src.bean.Course;
import com.lt.src.exception.CourseNotAddException;
import com.lt.src.repository.CourseDaoImpl;
import com.lt.src.serviceImpl.CourseService;
import com.lt.src.serviceInt.CourseServiceInterface;

import ch.qos.logback.core.subst.Token.Type;

/**
 * @author user217
 *
 */
@RestController
public class CourseController {

	@Autowired
	CourseServiceInterface couseService;
	
	@Autowired
	CourseDaoImpl dao;
//	
//	@RequestMapping(value="/addCourse",method = RequestMethod.POST)
//	public ResponseEntity getCourse(@RequestBody Course course)
//	{
//	        dao.saveCourse(course);
//	return new ResponseEntity(course, HttpStatus.OK);
//	}
	
	@RequestMapping(value="/addCourse",method = RequestMethod.POST)
	public ResponseEntity SaveCourseDetails (@RequestBody Course course) {
	
	       couseService.addCourse(course);
		return new ResponseEntity(course, HttpStatus.OK);
		
	}

	/**
	 * @return the Course List 
	 */
	@RequestMapping(value="/courseList",method = RequestMethod.GET)
	public List<Course> getCourseList() {

		return couseService.getCourses();
	}
	
	
//	@RequestMapping(value="/branches",method = RequestMethod.GET)
//	public List<Course> getCourseBranchesList(@PathVariable String name,@RequestBody Course course){
//		List <Course> list= couseService.getCoursesByCourseName(null);
//		for(Course cour : list) {
//			cour.setName(name);
//			System.out.println(cour.getName());
//		}
//		return list;
//		}
		
	@RequestMapping(value="/courseByName/{name}")
	public List  <Course> getCourseByName(@PathVariable List<String> name,@RequestBody Course course) throws CourseNotAddException {
		if(course.getName()== null) {
			
			throw new CourseNotAddException();
			}
		else {
			couseService.addCourse(course);
		}
		return couseService.getCoursesByCourseName(name);
	}

	
	
	
	
	
	}

	

