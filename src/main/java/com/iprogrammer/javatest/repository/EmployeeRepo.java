package com.iprogrammer.javatest.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iprogrammer.javatest.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public Set<Employee> findByDepartmentIs(String departName);
	public Set<Employee> findByCityIs(String city);

}
