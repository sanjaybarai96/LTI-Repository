package com.lt.src.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.constant.InputConstants;
import com.lt.src.bean.Course;
import com.lt.src.repository.CourseDaoImpl;
import com.lt.src.serviceInt.CourseServiceInterface;


@Service
public class CourseService implements CourseServiceInterface {
	
	@Autowired
	private CourseDaoImpl courseDao;
	
	@Override
	public void addCourse(Course course) {
			courseDao.saveCourse(course);
//			System.out.println("Course successfully added");
			
		}	
	@Override
	public String removeCourse(String id) {
		String status =courseDao.removeCourse(id);;
		return status;
	}
/*
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
*/
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

	@Override
	public List<Course> getCoursesByCourseCode(List<String> courseCodes) {
		return courseDao.getCourseByCourseCode(courseCodes);
	}
	

}
