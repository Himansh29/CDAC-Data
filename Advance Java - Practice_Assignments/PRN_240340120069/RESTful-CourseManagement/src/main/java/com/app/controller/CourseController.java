package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDTO;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	public CourseController() {
		System.out.println("Inside course controller");
		// Error handling is done in service layer using custom exception
	}
	
	@Autowired
	private CourseService service;
	
	@PostMapping("/")
	public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDTO courseDTO) { // Addting @Valid Annotation from spring-boot-starter-validation which gives us ready to use validation support for service side validation
		return ResponseEntity.status(HttpStatus.CREATED) // Sending proper response code i.e 201 for Resource created
				.body(service.addCourse(courseDTO));
	}
	
	@PutMapping("/{id}") // Updating course details and se
	public ResponseEntity<?> updateCourseDetails(@PathVariable Long id, @RequestBody @Valid CourseDTO courseDTO) {
		return ResponseEntity.status(HttpStatus.CREATED) // // Sending proper response code i.e 201 for Resource created
				.body(service.updateCourseDetails(id,courseDTO));
	}
	
	@GetMapping("/{courseName}") // Endpoint path with a path variable for courseName (Matches with entity/dto field name otherwise will throw exception) 
	public ResponseEntity<?> getAllCoursesByCourseName(@PathVariable String courseName) {
		return ResponseEntity.status(HttpStatus.OK) // Sending proper response code i.e is 200 for Resource found 
				.body(service.getAllCoursesByGivenCourseName(courseName));
	}
	

	@GetMapping("/by-month/{month}") // Endpoint path with a path variable for month
    public ResponseEntity<?> getAllCourseByGivenMonth(@PathVariable String month) {
        // Assuming month format is "yyyy-MM"
        return ResponseEntity.status(HttpStatus.OK) // Sending proper response code i.e is 200 for Resource found
                .body(service.getAllCoursesForGivenMonth(month));
    }

	
}
