package com.lt.src.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.src.bean.Course;
import com.lt.src.bean.Student;
import com.lt.src.serviceInt.BillingServiceInterface;

@Service
public class BillingService implements BillingServiceInterface {

	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private CourseService courseService;

	

	@Override
	public double generateBill(UUID userId) {
		Student  student = studentService.getStudentById(userId);
		double totalBill = 0;
		if(student.getCourse()!=null && !student.getCourse().isEmpty()) {
			List<Course> 	courses = courseService.getCoursesByCourseName(Arrays.asList(student.getCourse().split(",")));
			totalBill = courses.stream().mapToDouble(Course::getPrice).sum();
		}else {
			System.out.println("Please add the course.");
		}
		return totalBill;
	}
}
