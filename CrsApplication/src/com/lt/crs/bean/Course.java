package com.lt.crs.bean;

/**
 * @author user215
 * Course bean contains course members
 */
public class Course {

	private String courseCode;
	private String name;
	private boolean isOffered;
	private String instructor;
	private double price;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOffered() {
		return isOffered;
	}
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", name=" + name + ", isOffered=" + isOffered + ", instructor="
				+ instructor + ", price=" + price + "]";
	}
}
