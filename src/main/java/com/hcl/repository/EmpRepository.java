package com.hcl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer> {
	
	public Optional<Employee> findEmployeeById(Integer id);
	
	public void deleteEmployeeById(Integer id);
}
