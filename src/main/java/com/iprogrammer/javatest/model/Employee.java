package com.iprogrammer.javatest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name = "employee_id",nullable = false)
	private Long employeeId;
	
	@Column(name = "first_name",nullable = false)
	private String firstName;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@Column(name = "city",nullable = false)
	private String city;
	
	@Column(name = "age",nullable = false)
	private int age;
	
	@Column(name = "salary",nullable = false)
	private int salary;
	
	@Column(name = "department",nullable = false)
	private String department;
	
	
}
