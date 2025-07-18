package com.EmployeeMngt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeMngt.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
