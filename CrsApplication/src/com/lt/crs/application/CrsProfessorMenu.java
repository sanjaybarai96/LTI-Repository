package com.lt.crs.application;


import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.service.ProfessorService;
import com.lt.crs.service.ProfessorServiceInterface;
import com.lt.crs.service.UserService;
import com.lt.crs.service.UserServiceInterface;
import com.lt.crs.utils.Utils;

/**
 * @author user215
 * This is the professor menu
 *
 */
public class CrsProfessorMenu {

	private UserServiceInterface userService = new UserService();
	private ProfessorServiceInterface professorService = new ProfessorService();
	
	/*
	 * Professor Menu
	 * @params userObj
	 */
	public void createMenu(User userObj) {
		boolean isExit = false;
		while(!isExit) {
			Utils.printStatement(String.format(Menu.ProfessorMenu,Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
//				professorService.addGrades();
				break;
			case 2:
				professorService.viewEnrolledStudents(userObj);
				break;
			case 3:
				professorService.viewCourse(userObj);
				break;
			case 4:
				userObj = userService.userLogout(userObj);
				isExit = true;
				break;
			default:
				break;
			}
		}


	}
}
