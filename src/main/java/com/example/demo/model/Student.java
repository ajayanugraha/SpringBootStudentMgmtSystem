package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "parentName")
	private String parentName;
	
	@Column(name="roll")
	private int roll;
	
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "age")
	private int age;

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	Student(){
		
	}


	public Student(String name,int roll, String parentName, String phoneNumber, int age) {
		super();
		this.name = name;
		this.roll=roll;
		this.parentName = parentName;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", parent =" + parentName + "]";
	}
	
	
	

}
