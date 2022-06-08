/**
 * 
 */
package com.lt.src.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lt.constant.InputConstants;
import com.lt.src.bean.Course;
import com.lt.src.bean.RegisterCourse;
import com.lt.src.bean.Student;
import com.lt.src.exception.UserNotFoundException;
import com.lt.src.repository.CourseDaoImpl;
import com.lt.src.repository.StudentDaoImpl;
import com.lt.src.serviceInt.StuentServiceInterface;

import net.minidev.json.JSONObject;

/**
 * @author user217
 *
 */
@Service
public class StudentService implements StuentServiceInterface {

	@Autowired
	StudentDaoImpl stdDao;
	@Autowired
	CourseDaoImpl courseDao;
	// CourseService couseCourse = new CourseService();
	@Autowired
	private CourseService courseService;

	private Logger logger = Logger.getLogger(StudentService.class);

	@Override
	public List<Student> getStudentsByCourseName(List<String> course) {
		// TODO Auto-generated method stub
		// return stdDao.getStudentsByCourseCode(course);
		return null;
	}

	@Override
	public ResponseEntity<?> courseRegistration(JSONObject jsonBody) {
		try {
			logger.info("Body request :: " + jsonBody);
			UUID userId = UUID.fromString(jsonBody.getAsString(InputConstants.User_id));
			RegisterCourse registerCourse = new RegisterCourse();
			registerCourse.setStudentId(userId);
			registerCourse.setBranch(jsonBody.getAsString(InputConstants.Branch_Name));
			stdDao.saveCourseRegistration(registerCourse);
			logger.info("coure resgistered saved");
			updateStudent(userId, registerCourse.getBranch());
			return new ResponseEntity<>("Course resgistered succeesfull", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured in courseRegistration:: " + e.getMessage());
			return new ResponseEntity<>("Contact administrator", HttpStatus.CONFLICT);
		}
	}

	private void updateStudent(UUID userId, String branch) {
		Student student = stdDao.getStudentByID(userId);
		student.setBranch(branch);
		stdDao.updateStudent(student, userId);
	}

	/**
	 * drop course
	 */
	@Override
	public ResponseEntity<?> dropCourse(JSONObject jsonBody) {
		try {
			logger.info("Body request:: " + jsonBody);
			UUID stdUserId = UUID.fromString(jsonBody.getAsString(InputConstants.User_id));

			Student student = stdDao.getStudentByID(stdUserId);

			if (student != null) {
				String courseCode = jsonBody.getAsString(InputConstants.Course_Code);
				List<String> stdCourseCodeList = new ArrayList<String>(Arrays.asList(student.getCourse().split(",")));
				stdCourseCodeList.removeAll(Arrays.asList(courseCode.split(",")));
				student.setCourse(stdCourseCodeList.stream().collect(Collectors.joining(",")));
				stdDao.updateStudent(student, stdUserId);
			} else {
				throw new UserNotFoundException(jsonBody.getAsString(InputConstants.User_id));
			}
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		} catch (UserNotFoundException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>("Contact administrator", HttpStatus.CONFLICT);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>("Contact administrator", HttpStatus.CONFLICT);
		}
	}

	/**
	 * student list for the course
	 * 
	 * @return
	 */

	@Override
	public ResponseEntity<?> addCourse(JSONObject jsonBody) {
		UUID stdUserId = UUID.fromString(jsonBody.getAsString(InputConstants.User_id));
		Student student = stdDao.getStudentByID(stdUserId);
		if (student != null) {
			String courseCode = jsonBody.getAsString(InputConstants.Course_Code);
			student.setCourse((student.getCourse() == null || student.getCourse().isEmpty()) ? courseCode
					: String.join(",", student.getCourse(), courseCode));
			stdDao.updateStudent(student, stdUserId);
		} else {
			return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}

	@Override
	public void viewGrade() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudentById(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> getCourses() {
		return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
	}

	public ResponseEntity<?> getCourse(String id) {
		Student student = stdDao.getStudentByID(UUID.fromString(id));
		if (student.getCourse() != null && !student.getCourse().isEmpty()) {
			List<String> studentCourseCode = Arrays.asList(student.getCourse().split(","));
			List<Course> courses = courseDao.getCourseByCourseCode(studentCourseCode);
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please first add the course", HttpStatus.OK);
		}
	}

}
