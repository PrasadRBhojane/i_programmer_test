package com.iprogrammer.javatest.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iprogrammer.javatest.exception.DataNotFoundException;
import com.iprogrammer.javatest.model.EmployeeDTO;

@Service
public interface IEmployeeService {

	public ResponseEntity<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO);
	
	public ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO) throws DataNotFoundException;
	
	public ResponseEntity<String> employeeCount(String departName) throws DataNotFoundException;
	
	public ResponseEntity<String> employeeCountInCity(String city) throws DataNotFoundException;
}
