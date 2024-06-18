package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.entities.CourseName;
import com.app.entities.Student;

public interface StudentService {

	StudentDTO addStudent(StudentDTO dto);
	List<StudentDTO> getAllStudents();
	List<Student> getAllStudentsOfSpecificCourse(CourseName name);
	ApiResponse updateStudent(Long id, Student student);
	ApiResponse deleteStudentById(Long id);
}
