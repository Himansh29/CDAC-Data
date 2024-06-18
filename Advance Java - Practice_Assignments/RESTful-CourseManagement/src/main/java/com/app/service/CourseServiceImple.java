package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.entities.Course;
import com.app.exception.CustomException;
import com.app.repo.CourseRepository;

@Service
@Transactional
public class CourseServiceImple implements CourseService {

	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<CourseDTO> findCourseByCourseName(String courseName) {
		return repo
				.findByCourseName(courseName)
				.stream()
				.map(i->mapper.map(i, CourseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> findAllCourses() {
		return repo
				.findAll()
				.stream()
				.map(i->mapper.map(i, CourseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CourseDTO addCourse(CourseDTO courseDTO) {
		Course course = mapper.map(courseDTO, Course.class);
		
		if(course.getStartDate().isAfter(course.getEndDate())) {
			throw new CustomException("Course start date cannot be after the end date!!!");
		}else {
		return mapper.map(repo.save(course), CourseDTO.class);
		}
	}

	@Override
	public ApiResponse updateCourseDetails(Long id, CourseDTO courseDTO) {
		Course course = repo.findById(id).orElseThrow(() -> new CustomException("Course with id: " + id + " Not found"));
		
		if(courseDTO.getStartDate().isAfter(courseDTO.getEndDate())) {
			throw new CustomException("Course start date cannot be after the end date!!!");
		}
		
		repo.save(mapper.map(courseDTO, Course.class));
		
		return new ApiResponse("Course Updated Successfully!!");
	}

	@Override
	public ApiResponse deleteCourseById(Long id) {
		Course course = repo.findById(id).orElseThrow(() -> new CustomException("Course with id: " + id + " Not found"));
		repo.delete(course);
		return new ApiResponse("Course Deleted Successfully!!");
	}

}
