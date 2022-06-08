package com.crs.lt.daoimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.crs.lt.beans.RegisterCourse;
import com.crs.lt.beans.Student;
import com.crs.lt.constants.DataCollections;
import com.crs.lt.dao.StudentDao;

public class StudentDaoImpl implements StudentDao{
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
