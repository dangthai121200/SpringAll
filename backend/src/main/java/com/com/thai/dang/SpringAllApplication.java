package com.com.thai.dang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.com.thai.dang.domain.student.StudentDomainAdd;
import com.com.thai.dang.service.StudentService;

@SpringBootApplication
public class SpringAllApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringAllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentService.deleteAllStudent();
		studentService.addStudent(new StudentDomainAdd("Thai", "Bao", "Thai", "Bao"));
		studentService.addStudent(new StudentDomainAdd("Thai1", "Bao1", "Thai", "Bao"));
		studentService.addStudent(new StudentDomainAdd("Thai2", "Bao2", "Thai", "Bao"));
		studentService.addStudent(new StudentDomainAdd("Thai3", "Bao3", "Thai", "Bao"));
	}
}
