package com.com.thai.dang.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.com.thai.dang.domain.page.StudentPageRequest;
import com.com.thai.dang.domain.student.StudentDomain;
import com.com.thai.dang.domain.student.StudentDomainAdd;
import com.com.thai.dang.entity.Student;
import com.com.thai.dang.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Page<StudentDomain> getAllStudent(StudentPageRequest studentPageRequest) {
		Page<Student> pageStudent = studentRepository.findAll(studentPageRequest);
		Page<StudentDomain> StudentDomain = new PageImpl(pageStudent.toList(), studentPageRequest, pageStudent.getTotalElements());
		return StudentDomain;
	}

	@Override
	public void addStudent(StudentDomainAdd studentDomainAdd) {
		Student student = ConvertToStudentEntity(studentDomainAdd);
		studentRepository.save(student);
	}
	
	@Override
	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}

	@Override
	public Student ConvertToStudentEntity(StudentDomainAdd studentDomainAdd) {
		Student student = modelMapper.map(studentDomainAdd, Student.class);
		return student;
	}

	@Override
	public StudentDomain ConvertToStudentDomain(Student student) {
		StudentDomain studentDomain = modelMapper.map(student, StudentDomain.class);
		return studentDomain;
	}

	@Override
	public StudentDomain getStudentById(int id) {
		Student student = studentRepository.getById(id);
		StudentDomain studentDomain = ConvertToStudentDomain(student);
		return studentDomain;
	}

	

}
