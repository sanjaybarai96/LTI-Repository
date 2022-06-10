package com.lt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	
}
