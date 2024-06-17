package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPosting extends BaseEntity {

	@Column(length = 20)
	private String title;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 40)
	private String location;
	
	@Column(length = 100)
	private String description;
	
	@Column(length = 34)
	private String requirments;
	
	@NotNull
	private double salary;
	
	@NotNull
	private LocalDate postingDate;
}
