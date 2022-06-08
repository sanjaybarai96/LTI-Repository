package com.lt.crs.application;

import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.service.AdminService;
import com.lt.crs.service.AdminServiceInterface;
import com.lt.crs.service.CourseService;
import com.lt.crs.service.CourseServiceInterface;
import com.lt.crs.service.ProfessorService;
import com.lt.crs.service.ProfessorServiceInterface;
import com.lt.crs.service.UserService;
import com.lt.crs.service.UserServiceInterface;
import com.lt.crs.utils.Utils;


/**
 * @author user215
 * This is the admin menu
 *
 */
public class CrsAdminMenu {

	private AdminServiceInterface adminService = new AdminService();
	private UserServiceInterface userService = new UserService();
	private CourseServiceInterface courseService = new CourseService();
	private ProfessorServiceInterface professorService = new ProfessorService();
	
	/*
	 * @author user215
	 * Admin menu
	 * @params userObj
	 */
	public void createMenu(User userObj) {
		boolean isExit = false;
		while(!isExit) {
			Utils.printStatement(String.format(Menu.AdminMenu,Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
				courseService.addCourse();
				break;
			case 2:
				courseService.removeCourse();
				break;
			case 3:
				professorService.addProfessor();
				break;
			case 4:
				adminService.approveStudents();
				break;
			case 5:
				//generate report card
				System.out.println("work in progress");
				break;
			case 6:
				userObj = userService.userLogout(userObj);
				isExit = true;
				break;
			default:
				break;
			}
		}


	}
}
