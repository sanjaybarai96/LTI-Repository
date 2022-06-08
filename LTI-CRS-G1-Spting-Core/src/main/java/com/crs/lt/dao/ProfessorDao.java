package com.crs.lt.dao;

import com.crs.lt.beans.Professor;

public interface ProfessorDao {
	void saveProfessor(Professor professor);

	Professor getProfessor(String userName);
}
