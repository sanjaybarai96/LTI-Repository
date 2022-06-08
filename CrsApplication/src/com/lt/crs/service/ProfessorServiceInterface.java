package com.lt.crs.service;


import com.lt.crs.bean.User;

public interface ProfessorServiceInterface {

	void addProfessor();

	void viewEnrolledStudents(User userObj);

	void viewCourse(User userObj);

}
