package com.lt.src.serviceInt;

import java.util.List;
import java.util.UUID;

import com.lt.src.bean.User;

public interface AdminServiceInterface {

	public void addProfessor();
	public UUID approveStudents(UUID input);
	public void generateReportCard();
	public void addCourse();
	public List<User> getStudentList();
}
