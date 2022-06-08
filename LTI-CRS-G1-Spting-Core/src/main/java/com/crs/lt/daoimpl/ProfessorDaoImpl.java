package com.crs.lt.daoimpl;

import com.crs.lt.beans.Professor;
import com.crs.lt.constants.DataCollections;
import com.crs.lt.dao.ProfessorDao;

public class ProfessorDaoImpl implements ProfessorDao{

	@Override
	public void saveProfessor(Professor professor) {
		DataCollections.professors.add(professor);
	}

	@Override
	public Professor getProfessor(String userName) {
		return DataCollections.professors.stream().filter(professor->professor.getName().equals(userName))
										   .findAny().orElseGet(null);
	}

}
