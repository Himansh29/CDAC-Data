package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.entity.Course;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CourseRepository;

@Service
@Transactional 
public class CourseServiceImple implements CourseService {

	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CourseDTO addCourse(CourseDTO courseDTO) {
		Course course = mapper.map(courseDTO, Course.class);
		return mapper.map(repo.save(course), CourseDTO.class);
	}

	@Override
	public ApiResponse updateCourseDetails(Long id, CourseDTO courseDTO) {
		// TODO Auto-generated method stub
		String msg = "Course Updation Failed!!!";
		if(repo.existsById(id)) {
			Course existingCourse = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course with id: " + id + " Not found"));
			existingCourse.setCourseStartDate(courseDTO.getCourseStartDate());
			existingCourse.setCourseEndDate(courseDTO.getCourseEndDate());
			existingCourse.setFees(courseDTO.getFees());
			repo.save(existingCourse);
			msg = "Course Updated SUCCESSFULYY!!!";
		}
		return new ApiResponse(msg);
	}

	@Override
	public List<Course> getAllCoursesForGivenMonth(String givenDate) {
		LocalDate date = LocalDate.parse(givenDate + "-01"); // Start of the given month

	    // Get the month from the date
	    int month = date.getMonthValue();

	    // Call the repository method
	    List<Course> courses = repo.findAllCoursesForGivenMonth(month);

	    // Convert Course entities to CourseDTOs
	    List<CourseDTO> courseDTOs = courses.stream()
	            .map(entity -> mapper.map(courses, CourseDTO.class))
	            .collect(Collectors.toList());

	    return courses;
	}

	@Override
	public List<Course> getAllCoursesByGivenCourseName(String courseName) {
		List<Course> courseByName = repo.findAllCourseByName(courseName);
		return courseByName;
	}

}

