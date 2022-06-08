package com.lt.crs.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.constants.Role;
import com.lt.crs.service.UserService;
import com.lt.crs.service.UserServiceInterface;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.utils.Utils;



/**
 * @author user215
 *This is initial flow of the project
 *
 */
public class CrsApplication {
	static Role role;
	private static CrsAdminMenu crsAdminMenu = new CrsAdminMenu();
	private static CrsStudentMenu crsStudentMenu = new CrsStudentMenu();
	private static CrsProfessorMenu crsProfessorMenu = new CrsProfessorMenu();

	public static void main(String[] args) {
		loadAdmin();
		//needs to delete
//		loadUser();
//		loadProfessor();
		
		createMenu();
	}

	/*
	 * adding dummy course data
	 */
	private static void loadCourse(String name,String courseName) {
			Course course = new Course();
			course.setCourseCode(courseName);
			course.setInstructor(name);
			course.setName(courseName);
			course.setOffered(true);
			
			DataCollections.courses.add(course);
	}

	/*
	 * adding dummy professor data
	 */
	private static void loadProfessor() {
		Map<Integer, String> courses = new HashMap<>();
		courses.put(1, "JAVA");
		courses.put(2, "C++");
		courses.put(3, "Dot Net");
		courses.put(4, "NG");
		
		List<String> names = Arrays.asList("raju","sita","john","raju");
		int count=1;
		for(String name: names) {
			Professor professor = new Professor();
			professor.setName(name);
			DataCollections.professors.add(professor);
			loadCourse(name,courses.get(count++));
			
		}
		
	}
	
	/*
	 * adding dummy students data
	 */
	private static void loadStudents(UUID uuid,String course) {
		Student student = new Student();
		student.setCourse(course);
		student.setStudentId(uuid);
		
		DataCollections.students.add(student);
		
	}
	
	/*
	 * adding dummy user data
	 */
	private static void loadUser() {
		Map<Integer, String> courses = new HashMap<>();
		courses.put(1, "JAVA");
		courses.put(2, "C++");
		courses.put(3, "Dot Net");
		courses.put(4, "NG");
		List<String> names = Arrays.asList("sanjay","arjun","ravi","remo");
		int count=1;
		for(String name: names) {
			User user = new User();
			UUID uuid = UUID.randomUUID();
			user.setUserId(uuid);
			user.setUserName(name);
			user.setPassword("qwert");
			user.setIsApprove(1);
			user.setRole(Role.Student.name());
			user.setCreateDate(new Date());
			user.setSession(false);
			
			DataCollections.users.add(user);
			loadStudents(uuid, courses.get(count++));
		}
		names = Arrays.asList("raju","sita","john","albert");
		for(String name: names) {
			User user = new User();
			UUID uuid = UUID.randomUUID();
			user.setUserId(uuid);
			user.setUserName(name);
			user.setPassword("qwert");
			user.setIsApprove(1);
			user.setRole(Role.Professor.name());
			user.setCreateDate(new Date());
			user.setSession(false);
			
			DataCollections.users.add(user);
		}
		
		User user = new User();
		UUID uuid = UUID.randomUUID();
		user.setUserId(uuid);
		user.setUserName("vikram");
		user.setPassword("qwert");
		user.setIsApprove(1);
		user.setRole(Role.Student.name());
		user.setCreateDate(new Date());
		user.setSession(false);
		
		DataCollections.users.add(user);
		loadStudents(uuid, "JAVA");
	}

	/*
	 * Inital menu
	 */
	private static void createMenu() {
		boolean isExit = false;
		User userObj = null;
		UserServiceInterface userService = new UserService();

		while(!isExit) {
			Utils.printStatement(Menu.Title);
			Utils.printStatement(Menu.Options);
			Utils.printStatement(Menu.InitialMenu);
			InputConstants.optionNumber = InputConstants.sc.nextInt();

			switch (InputConstants.optionNumber) {
			case 1:
				userObj = userService.userLogin();
				break;
			case 2:
				userService.registerUser();
				break;
			case 3:
				userService.updatePassword();
				break;
			case 4:
				isExit = true;
				break;

			default:
				Utils.printStatement("Please enter proper options");
				break;
			}

			if(userObj!=null && userObj.getSession()) {
				Utils.printStatement(String.format(Menu.WeclomeMsg,userObj.getFirstName()));
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
				Utils.printStatement("Last Login :: "+ LocalDateTime.now().format(dtf));
				switch (Role.valueOf(userObj.getRole())) {
				case Student:
					crsStudentMenu.createMenu(userObj);
					break;
				case Professor:
					crsProfessorMenu.createMenu(userObj);
					break;
				case Admin:
					crsAdminMenu.createMenu(userObj);
					break;

				default:
					break;
				}
			}

		}
	}

	private static void loadAdmin() {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setUserName("admin");
		user.setPassword("admin");
		user.setFirstName("admin");
		user.setLastName("");
		user.setCreateDate(new Date());
		user.setRole(Role.Admin.name());
		user.setIsApprove(1);
		DataCollections.users.add(user);
		DataCollections.courseBranches.addAll(Arrays.asList("BSC","MBA","BA"));
	}
}

