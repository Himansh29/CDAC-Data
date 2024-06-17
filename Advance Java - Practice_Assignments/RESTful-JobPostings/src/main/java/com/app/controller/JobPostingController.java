package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JobPostingDTO;
import com.app.entity.JobPosting;
import com.app.service.JobPostingService;

@RestController
@RequestMapping("/jobpostings")
public class JobPostingController {

	public JobPostingController() {
		System.out.println("inside job posting controller");
	}
	
	@Autowired
	private JobPostingService service;
	
	@GetMapping("/") 
	public ResponseEntity<?> getAllJobPostings() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllJobPostings());
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addJobPosting(@RequestBody JobPostingDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addJobPosting(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobPostingDetails(@PathVariable Long id, @RequestBody JobPosting jobPosting) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateJobPosting(id, jobPosting));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobPosting(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteJobPosting(id));
	}
}
