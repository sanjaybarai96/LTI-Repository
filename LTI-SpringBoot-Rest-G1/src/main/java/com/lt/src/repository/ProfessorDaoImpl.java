package com.lt.src.repository;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.src.bean.Professor;
import com.lt.src.bean.User;

@Repository
public class ProfessorDaoImpl{

	
	public void saveProfessor(User user) {
		DataCollections.users.add(user);
	}

	public Professor getProfessor(String userName) {
		return DataCollections.professors.stream().filter(professor->professor.getName().equals(userName))
										   .findAny().orElseGet(null);
	}

}
