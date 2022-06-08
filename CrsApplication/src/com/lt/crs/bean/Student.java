package com.lt.crs.bean;

import java.util.UUID;

/**
 * @author user217
 * Student Class contained the information of student
 *
 */
public class Student {

	private UUID studentId;
	private String course;
	private String branch;
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
