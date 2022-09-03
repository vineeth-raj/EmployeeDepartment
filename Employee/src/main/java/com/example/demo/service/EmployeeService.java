package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Employee;
import com.example.demo.implementation.EmployeeImpl;
import com.example.demo.repository.EmployeeRepository;


@Service
@Component
public class EmployeeService implements EmployeeImpl {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}


   @Override

public List<Employee> getByDepartmentId(int departmentid){

List<Employee> employee = employeeRepository.findAll();
		for (Employee s : employee) {
			if (s.getDepartmentid() == departmentid) {
				return (List<Employee>) s;
			}
		}
		return null;}
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int id = employeeRepository.findAll().size() + 1;
		employee.setId(id);
		employeeRepository.save(employee);
		return employee;
	}
@Override
	public List<Employee> addList(List<Employee> employee) {
		employeeRepository.saveAll(employee);
		return employee;
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public AddResponse deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Employee Deleted...");
		return res;
	}

}