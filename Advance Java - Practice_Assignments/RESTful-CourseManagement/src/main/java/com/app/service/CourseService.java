package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;

public interface CourseService {

	List<CourseDTO> findCourseByCourseName(String courseName);
	List<CourseDTO> findAllCourses();
	CourseDTO addCourse(CourseDTO courseDTO);
	ApiResponse updateCourseDetails(Long id, CourseDTO courseDTO);
	ApiResponse deleteCourseById(Long id);
}
