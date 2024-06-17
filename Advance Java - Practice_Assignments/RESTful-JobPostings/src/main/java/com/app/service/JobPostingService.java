package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDTO;
import com.app.entity.JobPosting;

public interface JobPostingService {

	List<JobPostingDTO> getAllJobPostings();
	JobPostingDTO addJobPosting(JobPostingDTO jobPostingDTO);
	ApiResponse updateJobPosting(Long id, JobPosting jobPosting);
	ApiResponse deleteJobPosting(Long id);
	
}
