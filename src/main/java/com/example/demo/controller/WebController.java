package com.example.demo.controller;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InternalReport;
import com.example.demo.model.Student;
import com.example.demo.repo.InternalReportRepository;
import com.example.demo.repo.StudentRepository;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/api/student")
public class WebController {
	@Autowired
	StudentRepository repository;
	@Autowired
	InternalReportRepository internalReportRepository;
	
	@PostMapping("/add")
	public Student process(@RequestBody Student student) {
		Student _student= repository.save(new Student(student.getName(), student.getRoll(), student.getParentName(),student.getPhoneNumber() , student.getAge()));
		return _student;
	}
	
	
	
	  @GetMapping(value = "name/{name}")
	  public List<Student> findByName(@PathVariable("name") String name) {
	  
	  List<Student> students = repository.findByName(name);
	  return students; 
	  }
	  @GetMapping("/students")
		public List<Student> getAllCustomers() {
			System.out.println("Get all Students...");

			List<Student> students = new ArrayList<>();
			repository.findAll().forEach(students::add);

			return students;
		}
	  @DeleteMapping("/{id}")
		public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
			System.out.println("Delete student with ID = " + id + "...");

			repository.deleteById(id);

			return new ResponseEntity<>("Student has been deleted!", HttpStatus.OK);
		}
	 
	  @PostMapping("/addmarks")
		public InternalReport process(@RequestBody InternalReport internalReport) {
		  try {
		  InternalReport _internalReport= internalReportRepository.save(new InternalReport(internalReport.getRoll(),internalReport.getPhysicsMarks(),internalReport.getChemistryMarks(),internalReport.getMathsMarks(),internalReport.getInternalNumber()));
		  return _internalReport;
		  }
		  catch(Exception e) {
			  System.out.println(e.getMessage());
			  return new InternalReport();
			  
		  }
		  
		}
	  
	  @GetMapping(value = "roll/{roll}")
	  public List<InternalReport> findByName(@PathVariable("roll") int roll) {
		  System.out.println("Get marks by Roll");
	  
	  List<InternalReport> internalReports = internalReportRepository.findByRoll(roll);
	  return internalReports; 
	  }
		
	

}
