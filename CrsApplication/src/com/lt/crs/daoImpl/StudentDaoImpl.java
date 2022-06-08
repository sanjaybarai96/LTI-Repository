package com.lt.crs.daoImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.RegisterCourse;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.StudentDao;
import com.lt.crs.service.StudentService;

/**
 * @author user217
 *student Service contatined the student information here
 */
public class StudentDaoImpl implements StudentDao {

	
//	StudentService studentService = new StudentService();
	@Override
	public List<Student> getStudentsByCourseName(List<String> courses) {
		
		return DataCollections.students.stream()
				.filter(student-> (student.getCourse()!=null && courses.stream().filter(course->student.getCourse().contains(course)).findAny().isPresent()))
				.collect(Collectors.toList());
	}

	@Override
	public void courseRegistration(RegisterCourse registerCourse) {
		
		DataCollections.registerCourse.add(registerCourse);
	}

	@Override
	public void dropCourse() {
//		studentService.dropCourse();
	}

	@Override
	public List<String> addCourse(List<String> courses) {
//		return DataCollections.courseBranches.stream()
//				.filter(student-> courses.stream().filter(course->student..contains(course)).findAny().isPresent())
//				.collect(Collectors.toList());
		return null;
		
	}

	@Override
	public void viewGrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudentByID(UUID userId) {
		// TODO Auto-generated method stub
		return DataCollections.students.stream().filter(student-> student.getStudentId().equals(userId))
				.findAny().orElse(null);
				
		
	}

	@Override
	public void updateStudent(Student student, UUID userId) {
		DataCollections.students.stream().filter(std-> std.getStudentId().equals(userId))
		.map(std->std=student).collect(Collectors.toList());
	}

	@Override
	public void save(Student student) {
		DataCollections.students.add(student);
	}
}
