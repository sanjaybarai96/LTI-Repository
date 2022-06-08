package com.lt.constant;


import java.util.ArrayList;
import java.util.List;

import com.lt.src.bean.Course;
import com.lt.src.bean.Payment;
import com.lt.src.bean.Professor;
import com.lt.src.bean.RegisterCourse;
import com.lt.src.bean.Student;
import com.lt.src.bean.User;


public class DataCollections {

	public static List<User> users = new ArrayList<>();
	public static List<Course> courses = new ArrayList<>();
	public static List<Professor> professors = new ArrayList<>();
	public static List<Student> students = new ArrayList<>();
	public static List<String> courseBranches = new ArrayList<>();
	public static List<RegisterCourse> registerCourse = new ArrayList<>();
	public static List<Payment> payments = new ArrayList<>();
	
}
