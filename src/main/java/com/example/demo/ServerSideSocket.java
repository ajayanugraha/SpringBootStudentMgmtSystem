package com.example.demo;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.repo.InternalReportRepository;
import com.example.demo.repo.StudentRepository;

import java.io.*;

import com.example.demo.controller.WebController;
import com.example.demo.model.InternalReport;
import com.example.demo.model.Student;

@Component
@Scope("prototype")


public class ServerSideSocket implements Runnable { 
	@Autowired 
	private ExportService exportService;
	
	@Autowired
	FileManager fileManager;
	
	 @Autowired 
	 StudentRepository studentRepository;
	 
	 @Autowired
	 InternalReportRepository internalReportRepository;
	  
	 // @Autowired FileManager fileManager;
	 
public void run() {
	try {
		int serverPort = 4020;
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(serverPort);
		serverSocket.setSoTimeout(100000000); 
		while(true) {
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "..."); 

			Socket server = serverSocket.accept();
			System.out.println("Just connected to " + server.getRemoteSocketAddress()); 

			PrintWriter toClient = 
				new PrintWriter(server.getOutputStream(),true);
			BufferedReader fromClient =
				new BufferedReader(
						new InputStreamReader(server.getInputStream()));
			String line = fromClient.readLine();
			System.out.println("Server received: " + line); 
			toClient.println("Thank you for connecting");
			
			
			List<Student> students = (List<Student>) studentRepository.findAll();
			
			
			
				try {
				FileOutputStream fos=new FileOutputStream("StudentRecordFinal.ser");
			ObjectOutputStream oos=null;
			oos=new ObjectOutputStream(fos);
			oos.writeObject(students);
			oos.close();
			fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR!!!");
			}
			System.out.println("EXPORTED");
			//exportService.saveStudentsToFile();
			//System.out.println("EXPORT SERVICE");
			/*List<Student> students=studentRepository.findById(4);`
			for(Student s:students) {
				System.out.println(s.getName());
			}
			
			/*
			 * fileManager.save(student); System.out.println("SAVED!!!");
			 * System.out.println("Students generated");
			 */
			/*
			 * System.out.println("FILE MANAGER"); FileOutputStream fos=new
			 * FileOutputStream("StudentRecord.ser"); ObjectOutputStream oos=null; oos=new
			 * ObjectOutputStream(fos); oos.writeObject(student); oos.close(); fos.close();
			 */
			System.out.println("EXPORTED");
			
		}
	}
	catch(UnknownHostException ex) {
		ex.printStackTrace();
	}
	catch(IOException e){
		e.printStackTrace();
	}
  }
	
  public static void main(String[] args) {
		ServerSideSocket srv = new ServerSideSocket();
		srv.run();
  }
}