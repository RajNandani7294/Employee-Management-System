package com.EmployeeMngt.Service;

import java.util.List;


import com.EmployeeMngt.Entity.Employee;


public interface EmployeeService {
  
	public String createEmployee(Employee emp);
	
	public List<Employee> GetAllRecorde();
	
	public Employee GetById(int id);
	
	public String updateRecorde(int id, Employee employee);
	
	public String deleteRecorde(int id);
}
