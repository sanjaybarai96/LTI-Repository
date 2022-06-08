package com.crs.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.crs.lt.beans.Course;
import com.crs.lt.configuration.AppConfig;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Menu;
import com.crs.lt.service.AdminServiceInterface;
import com.crs.lt.service.CourseServiceInterface;
import com.crs.lt.service.ProfessorServiceInterface;
import com.crs.lt.serviceimpl.AdminService;
import com.crs.lt.serviceimpl.CourseService;
import com.crs.lt.serviceimpl.ProfessorService;
import com.crs.lt.util.Utils;
import com.lt.crs.client.CrsWelcomeApplication;


@SpringBootApplication
@ComponentScan({"com.crs.lt.*"})
@Import({AppConfig.class})
public class LtiCrsG1SptingCoreApplication {

	private static CourseServiceInterface courseService = new CourseService();
	private static ProfessorServiceInterface professorService = new ProfessorService();
	private static AdminServiceInterface adminService = new AdminService();
	
	public static void main(String[] args) {
//		SpringApplication.run(LtiCrsG1SptingCoreApplication.class, args);
		ApplicationContext context=SpringApplication.run(AppConfig.class);
		
//		CourseService courseService = (CourseService) context.getBean("courseBean");
//		ProfessorServiceInterface professorSevice = (ProfessorServiceInterface) context.getBean("professorBean");
//		AdminServiceInterface adminService = (AdminServiceInterface) context.getBean("adminBean");
		
		CrsWelcomeApplication welcomeMenu = (CrsWelcomeApplication) context.getBean("welcomeMenu");
		welcomeMenu.createMenu(context);
		
	}
}

//		Utils.printStatement(Menu.Title);
//		Utils.printStatement(Menu.Options);
//		Utils.printStatement(Menu.InitialMenu);
//		InputConstants.optionNumber = InputConstants.sc.nextInt();
//		if(InputConstants.optionNumber == 1) {
//			Utils.printStatement("*****WELCOME ADMIN*****");
//			Utils.printStatement(Menu.AdminMenu);
//			InputConstants.optionNumber = InputConstants.sc.nextInt();
//			switch (InputConstants.optionNumber) {
//			case 1:
//				courseService.addCourse();
//				break;
//			case 2:
//				courseService.removeCourse();
//				break;
//			case 3:
//				professorSevice.addProfessor();
//				break;
//			case 4:
//				adminService.approveStudents();
//				break;
//			case 5:
//				//generate report card
//				System.out.println("work in progress");
//				break;
//			case 6:
////				userObj = userService.userLogout(userObj);
////				isExit = true;
//				break;
//			default:
//				break;
//			}
//		}else {
//			Utils.printStatement("*****Thank You******");
//		}