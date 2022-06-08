/**
 * 
 */
package com.lt.crs.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.RegisterCourse;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.dao.CourseDao;
import com.lt.crs.dao.StudentDao;
import com.lt.crs.daoImpl.CourseDaoImpl;
import com.lt.crs.daoImpl.StudentDaoImpl;

/**
 * @author user217
 *
 */
public class StudentService implements StuentServiceInterface{

	StudentDao stdDao = new StudentDaoImpl();
	CourseDao courseDao = new CourseDaoImpl();
	//CourseService couseCourse = new CourseService();
	
	private CourseService courseService = new CourseService();
	@Override
	public List<Student> getStudentsByCourseName(List<String> course) {
		// TODO Auto-generated method stub
		return stdDao.getStudentsByCourseName(course);
	}

	@Override
	public void courseRegistration(User user) {
	System.out.println("please Select the Course");
	List<String> branchesCourse=courseService.getCourseBranchList();
	 RegisterCourse registerCourse = new RegisterCourse();
		int increment = 0;
		for(String branch:branchesCourse) {
		System.out.println(++increment+". "+branch);
		}
		System.out.println("Type correspondence option number to choose  the course");
		System.out.println("If you want to exit press "+ (branchesCourse.size()+1));
		InputConstants.optionNumber = InputConstants.sc.nextInt();
		if(InputConstants.optionNumber != branchesCourse.size()+1)
		{
			registerCourse.setStudentId(user.getUserId());
			registerCourse.setBranch(branchesCourse.get(InputConstants.optionNumber-1));
			stdDao.courseRegistration(registerCourse);
			updateStudent(user.getUserId(),registerCourse.getBranch());
			System.out.println("Course Register successfully ");
		}
		
	}

	private void updateStudent(UUID userId, String branch) {
		Student student = stdDao.getStudentByID(userId);
		student.setBranch(branch);
		stdDao.updateStudent(student, userId);
	}

	/**
	 *drop course
	 */
	@Override
	public void dropCourse(UUID userId) {
		Student student  = stdDao.getStudentByID(userId);
		boolean isExit = false;
		while(!isExit) {
			if(student!= null && !student.getCourse().isEmpty()) {
				int increment = 0;
				List<String> listofCourses =new LinkedList<>(Arrays.asList(student.getCourse().split(",")));
						
 				for(String course : listofCourses) {
					System.out.println(++increment+". "+course);
				}
				System.out.println("Type correspondence option number to remove the course");
				System.out.println("If you want to exit press "+ (listofCourses.size()+1));
				InputConstants.optionNumber = InputConstants.sc.nextInt();
				if(InputConstants.optionNumber == listofCourses.size()+1)
					isExit = true;
				else {
					listofCourses.remove(InputConstants.optionNumber-1);
					student.setCourse(listofCourses.stream().collect(Collectors.joining(",")));
					stdDao.updateStudent(student, userId);
					System.out.println("Course remove successfully");
				}
			}else {
				System.out.println("No course list found");
				isExit = true;
			}
		}

		
	}

	/**
	 * studen list for the course
	 */
	
	@Override
	public void addCourse(UUID userId) {
		Student student  = stdDao.getStudentByID(userId);
		System.out.println("please choose the courses  ");
		List<Course > courses=courseService.getCourses();
			boolean isExit = false;
			while(!isExit) {
				if(courses.size()>0) {
					int increment = 0;
					for(Course course:courses){ 
						System.out.println(++increment+". "+course);
					}
					System.out.println("Type correspondence option number to remove the course");
					System.out.println("If you want to exit press "+ (courses.size()+1));
					InputConstants.optionNumber = InputConstants.sc.nextInt();
					if(InputConstants.optionNumber == courses.size()+1)
						isExit = true;
					else {
						Course cor=courses.get(InputConstants.optionNumber-1);
						student.setCourse((student.getCourse()==null || student.getCourse().isEmpty())?cor.getName():String.join(
								",",student.getCourse(),cor.getName()));
						stdDao.updateStudent(student,userId);
						System.out.println("Course added successfully");
					}
				}else {
					System.out.println("No course list found");
					isExit = true;
				}
			}	
			
	}

	@Override
	public void viewGrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStudent(Student student) {
		stdDao.save(student);
	}

	@Override
	public Student getStudentById(UUID userId) {
		return stdDao.getStudentByID(userId);
	}

}
