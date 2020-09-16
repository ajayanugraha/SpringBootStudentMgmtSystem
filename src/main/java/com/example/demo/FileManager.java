package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component

public class FileManager {

	public void save(Student students) throws IOException {
		System.out.println("FILE MANAGER");
		FileOutputStream fos=new FileOutputStream("StudentRecordFinal.ser");
		ObjectOutputStream oos=null;
		oos=new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
		fos.close();
		
	}

	

}
