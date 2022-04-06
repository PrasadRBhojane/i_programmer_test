package com.iprogrammer.javatest.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iprogrammer.javatest.exception.DataNotFoundException;
import com.iprogrammer.javatest.model.EmployeeDTO;
import com.iprogrammer.javatest.service.IEmployeeService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Prasad
 *
 */
@RestController
@RequestMapping(path = "/v1")
@Log4j2
@Validated
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * This will get user data and save the same to the database.
	 * @param employeeDTO
	 * @return 
	 */
	@PostMapping(path = "/save-employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> saveEmployeeData(@NotNull @RequestBody EmployeeDTO employeeDTO) {
		log.debug("Inside controller saveEmployeeData {}" + employeeDTO);

		return employeeService.saveEmployee(employeeDTO);
	}

	/**
	 * This will update the user data in the database as per request
	 * 
	 */
	@PutMapping(path = "/update-employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> updateEmployeeData(@NotNull @RequestBody EmployeeDTO employeeDTO)
			throws DataNotFoundException {
		log.debug("Inside controller updateEmployeeData {}" + employeeDTO);

		return employeeService.updateEmployee(employeeDTO);
	}

	/**
	 * This will return max number of employee's which belongs to a particular department as requested.
	 * @param departName
	 * @return
	 * @throws DataNotFoundException
	 */
	@GetMapping(path = "/employee-list/departName/{departName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> employeeCount(@PathVariable String departName) throws DataNotFoundException {
		log.debug("Inside controller employeeCount {}" + departName);

		return employeeService.employeeCount(departName);
	}

	/**
	 * This will return max number of employee's which belongs to a particular city as requested.
	 * @param city
	 * @return
	 * @throws DataNotFoundException
	 */
	@GetMapping(path = "/employee-list/city/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> employeeCountInCity(@PathVariable String city) throws DataNotFoundException {
		log.debug("Inside controller employeeCountInCity {}" + city);

		return employeeService.employeeCountInCity(city);
	}

}
