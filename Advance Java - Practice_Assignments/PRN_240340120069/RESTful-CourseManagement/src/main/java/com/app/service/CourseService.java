package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.entity.Course;

public interface CourseService {

	CourseDTO addCourse(CourseDTO courseDTO);

	ApiResponse updateCourseDetails(Long id, CourseDTO courseDTO);

	List<Course> getAllCoursesForGivenMonth(String givenDate);

	List<Course> getAllCoursesByGivenCourseName(String courseName);
}
