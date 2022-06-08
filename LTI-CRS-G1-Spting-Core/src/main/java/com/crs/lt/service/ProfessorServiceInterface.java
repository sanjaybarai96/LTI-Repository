package com.crs.lt.service;

import com.crs.lt.beans.User;

public interface ProfessorServiceInterface {
	void addProfessor();

	void viewEnrolledStudents(User userObj);

	void viewCourse(User userObj);
}
