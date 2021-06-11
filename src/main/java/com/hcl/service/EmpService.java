package com.hcl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.UserNotFoundException;
import com.hcl.model.Employee;
import com.hcl.repository.EmpRepository;

@Service
@Transactional
public class EmpService {

	private final EmpRepository repo;

	@Autowired
	public EmpService(EmpRepository repo) {
		this.repo = repo;
	}

	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}

	public Employee findAllEmployeeById(Integer id) {
		return repo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}

	public void deleteEmployee(Integer id) {
		repo.deleteEmployeeById(id);
	}

	public List<Employee> findAllEmp() {
		return repo.findAll();
	}

	public Employee updateEmployee(Employee emp,Integer id) {
		// TODO Auto-generated method stub
		emp.setId(id);
		return repo.save(emp);
		
	}
}
