package com.crs.lt.beans;

public class Professor {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Professor [name=" + name + "]";
	}
	
}
