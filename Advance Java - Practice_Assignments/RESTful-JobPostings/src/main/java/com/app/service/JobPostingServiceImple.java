package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDTO;
import com.app.entity.JobPosting;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.JobPostingRepository;

@Service
@Transactional
public class JobPostingServiceImple implements JobPostingService {

	@Autowired
	private JobPostingRepository jobPostingRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<JobPostingDTO> getAllJobPostings() {
		return jobPostingRepository
				.findAll()
				.stream()
				.map(i->mapper.map(i, JobPostingDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public JobPostingDTO addJobPosting(JobPostingDTO jobPostingDTO) {
		JobPosting jobPosting = mapper.map(jobPostingDTO, JobPosting.class);
		return mapper.map(jobPostingRepository.save(jobPosting), JobPostingDTO.class);
	}

	@Override
	public ApiResponse updateJobPosting(Long id, JobPosting jobPosting) {
		String msg = "Job posting FAILED";
		if(jobPostingRepository.existsById(id)) {
			jobPostingRepository.save(jobPosting);
			msg = "Job Posting updated!!";
		}else {
			throw new ResourceNotFoundException("ID NOT FOUND");
		}
		return new ApiResponse(msg);
	}

	@Override
	public ApiResponse deleteJobPosting(Long id) {
		JobPosting posting = jobPostingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND"));
		jobPostingRepository.delete(posting);
		return new ApiResponse("Job posting deleted successfully");
	}

}
