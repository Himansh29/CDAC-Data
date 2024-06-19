package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO {
	
	// Adding validations in the DTO layer for enhanced readablility (Best Practice)

	@NotBlank
	private String name;

	@NotNull
	private Category category;

	@NotNull
	private LocalDate courseStartDate;

	@NotNull
	private LocalDate courseEndDate;

	@NotNull
	private Double fees;
}
