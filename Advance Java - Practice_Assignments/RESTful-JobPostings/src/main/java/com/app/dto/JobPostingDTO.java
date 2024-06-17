package com.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class JobPostingDTO {
	
	private String title;

	private String name;

	private String location;

	private String description;

	private String requirments;

	private double salary;

	private LocalDate postingDate;
}
