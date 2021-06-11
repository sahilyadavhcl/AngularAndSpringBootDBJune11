package com.hcl.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.model.Employee;
import com.hcl.service.EmpService;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmpController {

	private EmpService service;

	public EmpController(EmpService service) {
		this.service = service;
	}

	@GetMapping("/allEmps")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> emps = service.findAllEmp();
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") Integer id) {
		Employee emp = service.findAllEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee emp1 = service.addEmployee(emp);
		return new ResponseEntity<>(emp1, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
		service.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{Id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") Integer id) {
		Employee emp1 = service.updateEmployee(emp,id);
		return new ResponseEntity<>(emp1, HttpStatus.OK);
	}
}
