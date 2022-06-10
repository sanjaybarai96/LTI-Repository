package com.lt.src.repository;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.constant.Role;
import com.lt.src.bean.User;

@Repository
public class UserDaoImpl  {

	
	public User getUser(String username) {
		
		return DataCollections.users.stream()
			.filter(user->user.getUserName().equals(username)).findAny().orElse(null); 
	}
	public void saveUser(User user) {
		DataCollections.users.add(user);
	}

	public List<User> getAllUser() {
		return DataCollections.users;
	}

	public List<User> getAllStudentUser() {
		List<User> students = DataCollections.users.stream()
											 .filter(user->user.getRole().equals(Role.Student.name()))
											 .collect(Collectors.toList());
		return students;
	}
	public List<User> getStudentById(List<UUID> studentIds) {
		return DataCollections.users.stream()
					.filter(user->studentIds.stream().anyMatch(studentId->user.getUserId().equals(studentId))).collect(Collectors.toList());
	}

}
