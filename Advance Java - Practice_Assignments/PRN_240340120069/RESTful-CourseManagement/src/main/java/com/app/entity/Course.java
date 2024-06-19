package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course extends BaseEntity{

	@Column(name = "course_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "course_start_date")
	private LocalDate courseStartDate;
	
	@Column(name = "course_end_date")
	private LocalDate courseEndDate;
	
	@Column(name = "fees")
	private Double fees;
}
