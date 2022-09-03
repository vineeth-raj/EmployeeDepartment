package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/getallemployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employees = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/getemployeebyid/{id}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable(value="id") int id)
	{
		Employee employee = empService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);	}
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return empService.addEmployee(employee);
	}
	
@PostMapping("/addbulk")
	public ResponseEntity<List<Employee>> addBulk(@RequestBody List<Employee> employee){
		try {
			 List<Employee> emp=empService.addList(employee);
			 return new ResponseEntity<List<Employee>>(emp,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") int id, @RequestBody Employee employee)
	{
		try {
			Employee oldEmp = empService.getEmployeeById(id);
			oldEmp.setGender(employee.getGender());
			oldEmp.setDateofjoining(employee.getDateofjoining());
			oldEmp.setDepartmentid(employee.getDepartmentid());
			oldEmp.setName(employee.getName());
			oldEmp.setId(employee.getId());
			oldEmp.setSalary(employee.getSalary());
			oldEmp.setAge(employee.getAge());
			employee = empService.updateEmployee(oldEmp);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public AddResponse deleteEmployee(@PathVariable(value="id") int id)
	{
		AddResponse res = empService.deleteEmployee(id);
		return res;
	}

@GetMapping("department/{id}")
	public ResponseEntity<List<Employee>> getEmployeeBydepartment(@PathVariable(value="id")int id){

		try {
			List<Employee> list = empService.getByDepartmentId(id);
			return new ResponseEntity<List<Employee>>(list, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}