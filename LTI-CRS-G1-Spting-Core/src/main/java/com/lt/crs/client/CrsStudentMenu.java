package com.lt.crs.client;

import org.springframework.beans.factory.annotation.Autowired;

import com.crs.lt.beans.User;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Menu;
import com.crs.lt.service.UserServiceInterface;
import com.crs.lt.serviceimpl.StudentService;
import com.crs.lt.serviceimpl.UserService;
import com.crs.lt.util.Utils;

/**
 * @author user215
 * This is the Student menu
 *
 */
public class CrsStudentMenu {
	
	
	@Autowired
	private UserServiceInterface userService;
	private StudentService stdService = new StudentService();
	private CrsPaymentMenu paymentMenu = new CrsPaymentMenu();
	//private CourseService courseService = new CourseService();
	/*
	 * Student menu
	 * @params user
	 */
	public void createMenu(User user) {
		boolean isExit = false;
		while(!isExit) {
		if(user.getIsApprove() == 0) {
			Utils.printStatement("Wait for you account to be approval by admin");
			Utils.printStatement("1."+Menu.LogOut);
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			userService.userLogout(user);
			isExit=true;
		}else {
			Utils.printStatement(String.format(Menu.StudentMenu, Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
				//view catalog
				break;
			case 2:
				stdService.courseRegistration(user);
				break;
			case 3:
				//Add course
				stdService.addCourse(user.getUserId());
				break;
			case 4:
				//Drop course
				stdService.dropCourse(user.getUserId());
				break;
			case 5:
				//View Grades
				break;
			case 6:
				//Pay Fee
				paymentMenu.createMenu(user);
				break;
			case 7:
				userService.userLogout(user);
				isExit=true;
				break;
				
			default:
				break;
			}
		}
	}
 }
}
