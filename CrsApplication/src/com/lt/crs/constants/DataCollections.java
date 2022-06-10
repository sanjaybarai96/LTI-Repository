package com.lt.crs.constants;

import java.util.ArrayList;
import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Payment;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.RegisterCourse;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.User;

public class DataCollections {

	public static List<User> users = new ArrayList<>();
	public static List<Course> courses = new ArrayList<>();
	public static List<Professor> professors = new ArrayList<>();
	public static List<Student> students = new ArrayList<>();
	public static List<String> courseBranches = new ArrayList<>();
	public static List<RegisterCourse> registerCourse = new ArrayList<>();
	public static List<Payment> payments = new ArrayList<>();
	
}
