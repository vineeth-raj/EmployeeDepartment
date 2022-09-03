package com.example.demo.implementation;

import java.util.List;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Employee;

public interface EmployeeImpl {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	

public List<Employee> getByDepartmentId(int department);

	public Employee addEmployee(Employee employee);
	
public List<Employee> addList(List<Employee> employee);
	public Employee updateEmployee(Employee Employee);
	
	public AddResponse deleteEmployee(int id);
}
