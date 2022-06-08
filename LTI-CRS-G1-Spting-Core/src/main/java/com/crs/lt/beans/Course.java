package com.crs.lt.beans;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(courseCode, instructor, isOffered, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseCode, other.courseCode) && Objects.equals(instructor, other.instructor)
				&& isOffered == other.isOffered && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", name=" + name + ", isOffered=" + isOffered + ", instructor="
				+ instructor + ", price=" + price + "]";
	}
	
}
