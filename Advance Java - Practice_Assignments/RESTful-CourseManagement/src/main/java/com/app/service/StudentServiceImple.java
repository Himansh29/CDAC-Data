package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.exception.CustomException;
import com.app.repo.CourseRepository;
import com.app.repo.StudentRepository;

@Service
@Transactional
public class StudentServiceImple implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public StudentDTO addStudent(StudentDTO dto) {
		Course course = courseRepository.findByCourseUniqueContraintKey(dto.getCourse().getCourseUniqueContraintKey());
		System.out.println(course);
		Student student = mapper.map(dto, Student.class);
		student.setCourse(course);
		Student savedStudent = repo.save(student);
		return mapper.map(savedStudent, StudentDTO.class);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		return repo.findAll().stream().map(i -> mapper.map(i, StudentDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse updateStudent(Long id, Student std) {
		String msg = "Student Updation Failed";

		if (repo.existsById(id)) {
			repo.save(std);
			msg = "Student Details updated successfully";
		}
		return new ApiResponse(msg);
	}

	@Override
	public ApiResponse deleteStudentById(Long id) {
		String msg = "Student deleted successfully";
		Student student = repo.findById(id).orElseThrow(() -> new CustomException("Student Not found!!"));
		repo.delete(student);
		return new ApiResponse(msg);

	}

}
