package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

}
