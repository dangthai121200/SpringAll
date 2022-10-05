package com.com.thai.dang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.com.thai.dang.domain.page.StudentPageRequest;
import com.com.thai.dang.domain.student.StudentDomain;
import com.com.thai.dang.entity.Student;
import com.com.thai.dang.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public Page<StudentDomain> getAllStudent(@RequestBody StudentPageRequest studentPageRequest) {
		return studentService.getAllStudent(studentPageRequest);
	}
	
	@GetMapping
	public StudentDomain getStudentById(@RequestParam(name = "idStudent", required = true) int idStudent) {
		return studentService.getStudentById(idStudent);
	}

}
