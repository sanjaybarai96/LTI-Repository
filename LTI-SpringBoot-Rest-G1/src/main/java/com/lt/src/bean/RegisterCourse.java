package com.lt.src.bean;

/**
 * 
 */


import java.util.UUID;

/**
 * @author user217
 *
 */
public class RegisterCourse {
	private UUID studentId;
	private String branch;
	
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	

}
