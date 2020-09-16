package com.example.demo.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.InternalReport;



public interface InternalReportRepository extends CrudRepository<InternalReport, Long> {
	List<InternalReport> findById(long id);
	
	//@Query("select s.internalreport from student s where s.roll=?1")
	List<InternalReport> findByRoll(int roll);



}
