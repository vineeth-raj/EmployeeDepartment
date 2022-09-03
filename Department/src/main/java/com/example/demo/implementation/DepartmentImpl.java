package com.example.demo.implementation;

import java.util.List;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Department;

import com.example.demo.vo.DepartmentVO;

public interface DepartmentImpl {
	
	public List<Department> getAllDepartments();
	
	public Department getDepartmentById(int id);
	
	public Department addDepartment(Department department);
	
public List<Department> addList(List<Department> department);
	public Department updateDepartment(Department Department);
	
 public List<DepartmentVO> EmployeeforParticulardepartment(String name);	public AddResponse deleteDepartment(int id);
}
