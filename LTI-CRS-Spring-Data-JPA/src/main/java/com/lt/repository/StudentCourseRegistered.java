package com.lt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.StudentRegistered;

@Repository
public interface StudentCourseRegistered extends CrudRepository<StudentRegistered, Long> {

}
