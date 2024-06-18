package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "course_name")
	private CourseName courseName;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "course_unique_key")
	private String courseUniqueContraintKey;
	
	@Column(nullable = false, name = "start_date")
	private LocalDate startDate;
	
	@Column(nullable = false, name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "course_fees")
	private double fees;
	
	private String grade;
	
}
