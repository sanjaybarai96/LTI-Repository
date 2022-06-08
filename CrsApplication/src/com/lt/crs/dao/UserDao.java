package com.lt.crs.dao;

import java.util.List;
import java.util.UUID;

import com.lt.crs.bean.User;
import com.lt.crs.constants.Role;

public interface UserDao {

	
	User getUser(String username);
	List<User> getAllUser();
	List<User> getAllStudentUser();
	void saveUser(User user);
	List<User> getStudentById(List<UUID> collect);
}
