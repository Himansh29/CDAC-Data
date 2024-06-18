package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Category;
import com.app.entities.CourseName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {

	private CourseName courseName;

	private Category category;

	private LocalDate startDate;

	private LocalDate endDate;
	
	private String courseUniqueContraintKey;

	private double fees;
	
	private String grade;
}
