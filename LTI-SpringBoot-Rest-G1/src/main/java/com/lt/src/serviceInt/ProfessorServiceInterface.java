package com.lt.src.serviceInt;

import com.lt.src.bean.Professor;
import com.lt.src.bean.User;

public interface ProfessorServiceInterface {

	void addProfessor(User user );

	void viewEnrolledStudents(User userObj);

	void viewCourse(User userObj);

}
