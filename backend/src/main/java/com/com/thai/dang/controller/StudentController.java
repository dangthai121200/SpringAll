package com.com.thai.dang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.com.thai.dang.domain.page.StudentPageRequest;
import com.com.thai.dang.entity.Student;
import com.com.thai.dang.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public Page<Student> getAllStudent(@RequestBody StudentPageRequest studentPageRequest) {
		return studentService.getAllStudent(studentPageRequest);
	}

}
