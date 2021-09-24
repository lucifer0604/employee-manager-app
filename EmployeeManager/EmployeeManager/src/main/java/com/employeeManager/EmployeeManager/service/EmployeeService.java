package com.employeeManager.EmployeeManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManager.EmployeeManager.exception.UserNotFoundException;
import com.employeeManager.EmployeeManager.model.Employee;
import com.employeeManager.EmployeeManager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
	
	
	public Employee findEmployeeById(Long id)
	{
		return employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
	}
	
	public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }

}
