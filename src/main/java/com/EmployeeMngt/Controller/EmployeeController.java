package com.EmployeeMngt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeMngt.Entity.Employee;
import com.EmployeeMngt.Service.EmployeeService;

@RestController 
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
    
	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp){
		return ResponseEntity.ok(employeeservice.createEmployee(emp));
	}
	
	@GetMapping()
	public ResponseEntity<List<Employee>> GetAll(){
		return ResponseEntity.ok(employeeservice.GetAllRecorde());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> GetById(@PathVariable int id){
		return ResponseEntity.ok(employeeservice.GetById(id));
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateRecord(@PathVariable int id, @RequestBody Employee employee){
		return ResponseEntity.ok(employeeservice.updateRecorde(id, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecord(@PathVariable int id){
		return ResponseEntity.ok(employeeservice.deleteRecorde(id));
	}
}
