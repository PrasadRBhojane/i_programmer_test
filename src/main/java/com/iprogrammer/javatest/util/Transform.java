package com.iprogrammer.javatest.util;

import org.springframework.stereotype.Component;

import com.iprogrammer.javatest.model.Employee;
import com.iprogrammer.javatest.model.EmployeeDTO;

@Component
public class Transform {

	private Employee employee = new Employee();
	
	public Employee convertToEntity(EmployeeDTO dto) {
		employee.setEmployeeId(dto.getEmployeeId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setCity(dto.getCity());
		employee.setSalary(dto.getSalary());
		employee.setAge(dto.getAge());
		employee.setDepartment(dto.getDepartmentName());
		return employee;
	}
}
