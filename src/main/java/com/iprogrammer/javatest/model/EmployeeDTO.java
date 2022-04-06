package com.iprogrammer.javatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


	private Long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String city;
	
	private int age;
	
	private int salary;
	
	private String departmentName;
}
