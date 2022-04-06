package com.iprogrammer.javatest.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iprogrammer.javatest.exception.DataNotFoundException;
import com.iprogrammer.javatest.model.Employee;
import com.iprogrammer.javatest.model.EmployeeDTO;
import com.iprogrammer.javatest.repository.EmployeeRepo;
import com.iprogrammer.javatest.util.Transform;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	Transform transform;
	
	@Override
	public ResponseEntity<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO) {
		log.debug("Inside EmployeeServiceImpl saveEmployee {}"+employeeDTO);
		
		Employee employeeEntity = transform.convertToEntity(employeeDTO);
		
		employeeRepo.save(employeeEntity);
		log.debug("Data is saved in Employee table {}"+employeeEntity);
		return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO) throws DataNotFoundException {
		log.debug("Inside EmployeeServiceImpl updateEmployee {}"+employeeDTO);
		Optional<Employee> employee = employeeRepo.findById(employeeDTO.getEmployeeId());
		if(employee.isPresent()) {
			Employee entity = transform.convertToEntity(employeeDTO);
			employeeRepo.save(entity);
		}else {
			throw new DataNotFoundException("Employee not found with input id");
		}
		
		return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<String> employeeCount(String departName) throws DataNotFoundException {
		log.debug("Inside EmployeeServiceImpl employeeCount {}"+departName);
		Set<Employee> empList = employeeRepo.findByDepartmentIs(departName);
		if (empList.isEmpty()) {
			throw new DataNotFoundException("Employee not found with input department name");
		}
		log.debug("List of Employees for department",empList);
		int count = empList.size();
		String response = "Employees count for "+departName+" department is ->"+count;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<String> employeeCountInCity(String city) throws DataNotFoundException {
		log.debug("Inside EmployeeServiceImpl employeeCountInCity {}"+city);
		Set<Employee> empList = employeeRepo.findByCityIs(city);
		if (empList.isEmpty()) {
			throw new DataNotFoundException("Employee not found with input city name");
		}
		int count = empList.size();
		String response = "Employees count for "+city+" city is ->"+count;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}



}
