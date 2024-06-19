package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {

	// Adding custom queries for better and optimized performance
	// Each custom Query takes O(1) i.e constant time to be executed
	
	@Query("Select c from Course c where c.name = :name")
	List<Course> findAllCourseByName(String name);
	
	@Query("select c from Course c where MONTH(c.courseStartDate) = :month OR MONTH(c.courseEndDate) = :month")
	List<Course> findAllCoursesForGivenMonth(@Param("month") int month);
}
