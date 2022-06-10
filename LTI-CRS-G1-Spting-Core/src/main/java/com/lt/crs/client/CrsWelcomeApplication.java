package com.lt.crs.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.crs.lt.beans.User;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Menu;
import com.crs.lt.constants.Role;
import com.crs.lt.serviceimpl.UserService;

/**
 * @author user215
 *This is initial flow of the project
 *
 */
public class CrsWelcomeApplication {
	
	Role role;
	
	@Autowired
	UserService userService;

	/*
	 * Inital menu
	 */
	public void createMenu(ApplicationContext context) {
		
		CrsAdminMenu crsAdminMenu = (CrsAdminMenu) context.getBean("adminMenu");
		CrsStudentMenu crsStudentMenu = (CrsStudentMenu) context.getBean("studentMenu");
		CrsProfessorMenu crsProfessorMenu  = (CrsProfessorMenu) context.getBean("professorMenu");
//		CrsStudentMenu crsStudentMenu = null;
//		CrsProfessorMenu crsProfessorMenu  = null;
		boolean isExit = false;
		User userObj = null;

		while(!isExit) {
			System.out.println(Menu.Title);
			System.out.println(Menu.Options);
			System.out.println(Menu.InitialMenu);
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
				System.out.println("Please enter proper options");
				break;
			}

			if(userObj!=null && userObj.getSession()) {
				System.out.println(String.format(Menu.WeclomeMsg,userObj.getFirstName()));
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
				System.out.println("Last Login :: "+ LocalDateTime.now().format(dtf));
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

	public void loadAdmin() {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setUserName("admin");
		user.setPassword("admin");
		user.setFirstName("admin");
		user.setLastName("");
		user.setCreateDate(LocalDate.now());
		user.setRole(Role.Admin.name());
		user.setIsApprove(1);
//		DataCollections.users.add(user);
//		DataCollections.courseBranches.addAll(Arrays.asList("BSC","MBA","BA"));
	}
}

