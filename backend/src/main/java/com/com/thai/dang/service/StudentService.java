package com.com.thai.dang.service;

import org.springframework.data.domain.Page;

import com.com.thai.dang.domain.page.StudentPageRequest;
import com.com.thai.dang.domain.student.StudentDomain;
import com.com.thai.dang.domain.student.StudentDomainAdd;
import com.com.thai.dang.entity.Student;

public interface StudentService {

	public Page<Student> getAllStudent(StudentPageRequest studentPageRequest);

	public void addStudent(StudentDomainAdd studentDomainAdd);

	public StudentDomain getStudentById(int id);

	public void deleteAllStudent();

	public Student ConvertToStudentEntity(StudentDomainAdd studentDomainAdd);

	public StudentDomain ConvertToStudentDomain(Student student);

}
