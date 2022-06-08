package com.lt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lt.entity.Course;
import com.lt.entity.Student;
import com.lt.entity.StudentRegistered;
import com.lt.repository.CourseRepository;
import com.lt.repository.StudentCourseRegistered;
import com.lt.repository.StudentRepository;

import net.minidev.json.JSONObject;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	StudentCourseRegistered studentCourseReg;
	
	@Autowired
	CourseRepository courseRepo;

	/**
	 * course registration method
	 * 
	 * @param registerCourse
	 */
	public ResponseEntity<?> courseRegistration(StudentRegistered registerCourse) {
		studentCourseReg.save(registerCourse);
		Student student = new Student();
		student.setStudentId(registerCourse.getStudentId());
		student.setBranch(registerCourse.getBranch());
		studentRepo.save(student);
		return new ResponseEntity<>("Course resgistered succeesfull", HttpStatus.OK);
	}

//	private void updateStudent(long userId, String branch) {
//		Student student = studentDao.getStudentByID(userId);
//		student.setBranch(branch);
//		studentDao.updateStudent(student, userId);
//	}

	/**
	 * Getting all the course list
	 */
	public ResponseEntity<?> getCourses() {
		return new ResponseEntity<>(courseRepo.findAll(), HttpStatus.OK);
	}

	/**
	 * Get course belongs to student selected
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseEntity<?> getStudentCourse(long userId) {
		Student student = studentRepo.findById(userId).orElse(null);
		if (student!= null && student.getCourseCode() != null && !student.getCourseCode().isEmpty()) {
			List<String> studentCourseCode = Arrays.asList(student.getCourseCode().split(","));
			List<Map<String,Object>> courses = courseRepo.findByCourseCode(studentCourseCode);
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please first add the course", HttpStatus.OK);
		}
	}

	/**
	 * Adding the course by student
	 * 
	 * @param jsonBody
	 */
	public ResponseEntity<?> addCourse(JSONObject jsonBody) {
		long userId = Long.valueOf(jsonBody.get("userId").toString());
		Student student = studentRepo.findById(userId).orElse(null);
		if (student != null) {
			String courseCode = jsonBody.get("courseCode").toString();
			student.setCourseCode((student.getCourseCode() == null || student.getCourseCode().isEmpty()) ? courseCode
					: String.join(",", student.getCourseCode(), courseCode));
			studentRepo.save(student);
		} else {
			return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}

	/**
	 * Removing course by student
	 * 
	 * @param jsonBody
	 */
	public ResponseEntity<?> dropCourse(JSONObject jsonBody) {
			long userId = Long.valueOf(jsonBody.get("userId").toString());
			Student student = studentRepo.findById(userId).orElse(null);
			if (student != null) {
				String courseCode = jsonBody.get("courseCode").toString();
				List<String> stdCourseCodeList = new ArrayList<String>(
						Arrays.asList(student.getCourseCode().split(",")));
				stdCourseCodeList.removeAll(Arrays.asList(courseCode.split(",")));
				student.setCourseCode(stdCourseCodeList.stream().collect(Collectors.joining(",")));
				studentRepo.save(student);
			return new ResponseEntity<>(student, HttpStatus.OK);
			}
			return new ResponseEntity<>("No student found",HttpStatus.NOT_FOUND);
	}

//	public List<Student> getStudentsByCourseCode(List<String> courseCodes) {
//		List<Student> studentList = studentDao.getStudentByCourseCodes(courseCodes);
//		return studentList;
//	}

}
