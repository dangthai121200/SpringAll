package com.com.thai.dang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.com.thai.dang.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
