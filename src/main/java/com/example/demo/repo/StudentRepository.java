package com.example.demo.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findById(int id);
	List<Student> findByName(String name);
	//List<Student> findAll();
	
	
		
	
}


