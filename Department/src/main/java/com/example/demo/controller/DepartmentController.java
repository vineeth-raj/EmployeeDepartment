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
import com.example.demo.vo.DepartmentVO;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;
	
	@GetMapping("/getalldepartments")
	public ResponseEntity<List<Department>> getAllDepartments()
	{
		List<Department> departments = depService.getAllDepartments();
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}
	
	@GetMapping("/getdepartmentbyid/{id}")
	public ResponseEntity<Department> getDepartmentByid(@PathVariable(value="id") int id)
	{
		Department department = depService.getDepartmentById(id);
		return new ResponseEntity<Department>(department, HttpStatus.OK);	}
	
	@PostMapping("/adddepartment")
	public Department addDepartment(@RequestBody Department department)
	{
		return depService.addDepartment(department);
	}
	
@PostMapping("/addbulk")
	public ResponseEntity<List<Department>> addBulk(@RequestBody List<Department> department){
		try {
			 List<Department> dep=depService.addList(department);
			 return new ResponseEntity<List<Department>>(dep,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}	@PutMapping("/updatedepartment/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value="id") int id, @RequestBody Department department)
	{
		try {
			Department oldDep = depService.getDepartmentById(id);
			oldDep.setNoofemp(department.getNoofemp());
			oldDep.setName(department.getName());
			oldDep.setId(department.getId());
			department = depService.updateDepartment(oldDep);
			return new ResponseEntity<Department>(department, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Department>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/department-employee/{name}")
	public ResponseEntity<?> EmployeeList(@PathVariable(value="stream") String name){
		try{
			 List<DepartmentVO> col = depService.EmployeeforParticulardepartment(name);
		 return new ResponseEntity<List<DepartmentVO>>(col,HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	@DeleteMapping("/deletedepartment/{id}")
	public AddResponse deleteDepartment(@PathVariable(value="id") int id)
	{
		AddResponse res = depService.deleteDepartment(id);
		return res;
	}
}