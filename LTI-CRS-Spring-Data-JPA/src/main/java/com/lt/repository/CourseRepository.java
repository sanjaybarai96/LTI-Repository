package com.lt.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

	@Modifying
	@Query(value="select * from course where coursecode in (?1)", nativeQuery=true)
	List<Map<String,Object>> findByCourseCode(List<String> studentCourseCode);

}
