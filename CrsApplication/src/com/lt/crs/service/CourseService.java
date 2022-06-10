package com.lt.crs.service;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.dao.CourseDao;
import com.lt.crs.daoImpl.CourseDaoImpl;

public class CourseService implements CourseServiceInterface {
	
	private CourseDao courseDao = new CourseDaoImpl();
	
	@Override
	public void addCourse() {
		boolean isExit = false;
		while(!isExit) {
			Course course = new Course();
			System.out.println("Enter the course code");
			course.setCourseCode(InputConstants.sc.next());
			System.out.println("Enter the course name");
			course.setName(InputConstants.sc.next());
			System.out.println("Enter isOffered True or False");
			course.setOffered(InputConstants.sc.nextBoolean());
			System.out.println("Enter the instructor name");
			course.setInstructor(InputConstants.sc.next());
			System.out.println("Enter the price");
			course.setPrice(InputConstants.sc.nextDouble());
			courseDao.saveCourse(course);
			System.out.println("Course successfully added");
			System.out.println("Press 1 to exit or if you want to continue to add new course press 2");
			if(InputConstants.sc.nextInt()==1) {
				isExit = true;
			}
		}		
	}

	@Override
	public void removeCourse() {
		List<Course> courses =  courseDao.getAllCourse();
		boolean isExit = false;
		while(!isExit) {
			if(courses.size()>0) {
				int increment = 0;
				for(Course course : courses) {
					System.out.println(++increment+". "+course);
				}
				System.out.println("Type correspondence option number to remove the course");
				System.out.println("If you want to exit press "+ (courses.size()+1));
				InputConstants.optionNumber = InputConstants.sc.nextInt();
				if(InputConstants.optionNumber == courses.size()+1)
					isExit = true;
				else {
					courses.remove(InputConstants.optionNumber-1);
					System.out.println("Course remove successfully");
				}
			}else {
				System.out.println("No course list found");
				isExit = true;
			}
		}
	}

	@Override
	public Course getCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getCourseBranchList() {
		return courseDao.getAllBranchesCourses();
		
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.getAllCourse();
	}

	@Override
	public List<Course> getCoursesByCourseName(List<String> courses) {
		return courseDao.getCourseByCourseName(courses);
	}
	

}
