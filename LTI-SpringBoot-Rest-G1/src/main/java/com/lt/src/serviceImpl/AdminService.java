package com.lt.src.serviceImpl;

import java.util.Formatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.constant.InputConstants;
import com.lt.src.bean.User;
import com.lt.src.repository.StudentDaoImpl;
import com.lt.src.repository.UserDaoImpl;
import com.lt.src.serviceInt.AdminServiceInterface;

@Service
public class AdminService implements AdminServiceInterface{

	@Autowired
	private UserDaoImpl userDao;
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public UUID approveStudents(UUID input) {
		return studentDaoImpl.studentApproving(input);
	} 
/*
	@Override
	public void approveStudents() {
		List<User> students = userDao.getAllStudentUser();
		System.out.println("List of all unapproved student registration");
		if(students.size()>0) {
			boolean isExit = false;
			Formatter fmt = new Formatter();
			while(!isExit) {
				System.out.println();
				System.out.printf("%10s %38s %10s %10s\n","UUID","First Name","Last Name","Email Id");
				students.stream().filter(student->student.getIsApprove()==0).forEach(student->{
					System.out.printf("%3s %10s %10s %20s\n",student.getUserId().toString(),student.getFirstName(),student.getLastName(),student.getEmailId());
				});
//				System.out.println(fmt);
				System.out.println("Enter the uuid for student approve");
				System.out.println("Type 1 to exit this window");
				InputConstants.input = InputConstants.sc.next();
				if(InputConstants.input.equals("1")) {
					isExit = true;
				}else {
					studentApproving(students,UUID.fromString(InputConstants.input.toString()));
					System.out.println("Students approved");
				}
			}
		}
	}

	private void studentApproving(List<User> students, UUID input) {
		students.stream().filter(std->std.getUserId().equals(input))
						 .forEach(std->std.setIsApprove(1));
		
	}
*/
	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse() {
		
	}
	@Override
	public List<User> getStudentList() {
		return userDao.getAllStudentUser();
	}
	

}
