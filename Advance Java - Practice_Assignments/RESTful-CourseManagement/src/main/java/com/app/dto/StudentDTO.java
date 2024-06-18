package com.app.dto;

import com.app.entities.Course;

import lombok.Data;

@Data
public class StudentDTO {

	private String studentName;

	private String email;

	private String password;

	private Course course;
}
