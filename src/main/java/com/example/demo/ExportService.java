package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@Component
@Transactional
public class ExportService {
	@Autowired
	StudentRepository studentRepository ;
	
	@Autowired
	FileManager fileManager;
	
	public void saveStudentsToFile() {
		System.out.println("EXPORT SERVICE");
		//List<Student> students=(List<Student>) studentRepository.findAll();
		//System.out.println(students);
		Student student=new Student("ajay",4,"er","34",1);
		try {
			fileManager.save(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!!!");
		}
		
	}

}
