package com.com.thai.dang.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.com.thai.dang.domain.page.StudentPageRequest;
import com.com.thai.dang.domain.student.StudentDomain;
import com.com.thai.dang.domain.student.StudentDomainAdd;
import com.com.thai.dang.domain.student.UserDetailStudent;
import com.com.thai.dang.entity.Student;
import com.com.thai.dang.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService, UserDetailsService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Page<Student> getAllStudent(StudentPageRequest studentPageRequest) {
		Page<Student> pageStudent = studentRepository.findAll(studentPageRequest);
		return pageStudent;
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = findStudentByUserName(username);
		UserDetailStudent userDetailStudent = null;
		if (student != null) {
			userDetailStudent = new UserDetailStudent();
			userDetailStudent.setUsername(username);
			userDetailStudent.setPassword(student.getPassword());
			userDetailStudent.setAuthorities(new ArrayList<>());
		}

		return userDetailStudent;
	}

	@Override
	public Student findStudentByUserName(String username) {
		return studentRepository.findByusername(username);
	}
}
