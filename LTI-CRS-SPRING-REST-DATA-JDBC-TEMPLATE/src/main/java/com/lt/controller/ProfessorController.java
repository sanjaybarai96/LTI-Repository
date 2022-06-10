/**
 * 
 */
package com.lt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dto.User;
import com.lt.service.ProfessorService;

import net.minidev.json.JSONObject;

/**
 * @author user215
 *
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	/**
	 * get the student respective professor course
	 * 
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value = "/viewEnrolledStudents", method = RequestMethod.POST)
	public ResponseEntity<?> viewEnrolledStudents(@RequestBody JSONObject jsonObject) {
		return new ResponseEntity<>(professorService.viewEnrolledStudents(jsonObject), HttpStatus.OK);
	}

	/**
	 * professor can view the course respective
	 * 
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value = "/viewCourse/{professorId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewCourse(@PathVariable("professorId") long professorId) {
		return professorService.viewCourse(professorId);

	}
}