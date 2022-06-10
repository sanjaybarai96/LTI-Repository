package com.crs.lt.beans;

import java.util.UUID;

public class Student {
	private UUID studentId;
	private String course;
	private String branch;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", course=" + course + ", branch=" + branch + "]";
	}
	
}
