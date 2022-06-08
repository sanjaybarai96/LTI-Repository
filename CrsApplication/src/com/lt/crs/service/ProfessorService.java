package com.lt.crs.service;

import java.util.List;
import java.util.stream.Collectors;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Role;
import com.lt.crs.dao.CourseDao;
import com.lt.crs.dao.ProfessorDao;
import com.lt.crs.dao.StudentDao;
import com.lt.crs.dao.UserDao;
import com.lt.crs.daoImpl.CourseDaoImpl;
import com.lt.crs.daoImpl.ProfessorDaoImpl;
import com.lt.crs.daoImpl.StudentDaoImpl;
import com.lt.crs.daoImpl.UserDaoImpl;

public class ProfessorService implements ProfessorServiceInterface{

	private ProfessorDao professorDao = new ProfessorDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private CourseDao courseDao = new CourseDaoImpl();
	private StudentDao studentDao = new StudentDaoImpl();
	private UserService userService = new UserService(); 


	@Override
	public void addProfessor() {
		boolean isExit = false;
		while(!isExit) {
			User user = new User();
			Professor professor = new Professor(); 
			System.out.println("Enter the emailId");
			professor.setName(InputConstants.sc.next());
			professorDao.saveProfessor(professor);
			user.setUserName(professor.getName());
			user.setPassword("Admin@123");
			userService.createUser(user, 1, Role.Professor);
			userDao.saveUser(user);
			System.out.println("Professor successfully added");
			System.out.println("Press 1 to exit or if you want to continue to add new course press 2");
			if(InputConstants.sc.nextInt()==1) {
				isExit = true;
			}
		}		
	}

	@Override
	public void viewEnrolledStudents(User userObj) {
		List<Course> courses = courseDao.getCourseByInstructor(userObj.getFirstName());
		List<Student> students =  studentDao.getStudentsByCourseName(courses.stream().map(Course::getName).collect(Collectors.toList()));
		List<User> studentUsers = userDao.getStudentById(students.stream().map(Student::getStudentId).collect(Collectors.toList()));

		System.out.printf("%10s %10s","StudentName","Subject");
		System.out.println();
		studentUsers.stream().forEach(studentUser->{
			students.stream().filter(std->std.getStudentId().equals(studentUser.getUserId()))
			.forEach(std->{
				System.out.format("%10s %10s",studentUser.getUserName(),std.getCourse());
				System.out.println();
			});
		});
		System.out.println("Press 1 for go back");
		InputConstants.sc.nextInt();
	}


	@Override
	public void viewCourse(User userObj) {
		List<Course> courses = courseDao.getCourseByInstructor(userObj.getFirstName());
		System.out.printf("Subject");
		courses.stream().forEach(course->System.out.format("\n"+course.getName()));
		System.out.println();
		System.out.println("Press 1 for go back");
		InputConstants.sc.nextInt();
	}

}
