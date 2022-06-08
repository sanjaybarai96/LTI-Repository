package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="coursecode")
	private String courseCode;
	@Column(name="coursename")
	private String coursename;
	@Column(name="isoffered")
	private String isoffered;
	@Column(name="instructor")
	private String instructor;
	@Column(name="price")
	private double price;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String isOffered() {
		return isoffered;
	}
	public void setOffered(String isOffered) {
		this.isoffered = isOffered;
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
}
