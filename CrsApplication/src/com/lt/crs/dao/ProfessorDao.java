package com.lt.crs.dao;

import com.lt.crs.bean.Professor;

public interface ProfessorDao {

	void saveProfessor(Professor professor);

	Professor getProfessor(String userName);

}
