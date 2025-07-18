package com.EmployeeMngt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeMngt.Entity.Employee;
import com.EmployeeMngt.Repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeerepository;

	@Override
	public String createEmployee(Employee emp) {
	    employeerepository.save(emp);
	    return "Successfully Add the Record";
	}

	@Override
	public List<Employee> GetAllRecorde(){
		return employeerepository.findAll();
	}

	@Override
	public Employee GetById(int id) {
		return employeerepository.findById(id)
		.orElseThrow(()->new EntityNotFoundException("Employee not found with ID:" +id));	 
	}

	@Override
	public String updateRecorde(int id, Employee emp) {
		Employee employee = employeerepository.getById(id);
		employee.setName(emp.getName());
		employee.setEmailId(emp.getEmailId());
		employee.setAddress(emp.getAddress());
		employee.setMobileNo(emp.getMobileNo());
		employee.setSalary(emp.getSalary());
		employeerepository.save(employee);
		return "Successfully update Record";
	}

	@Override
	public String deleteRecorde(int id) {
		employeerepository.deleteById(id);
		return "Successfully delete Record";
	}

}
