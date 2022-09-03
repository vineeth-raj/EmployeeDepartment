package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.AddResponse;
import com.example.demo.entity.Department;
import com.example.demo.implementation.DepartmentImpl;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.vo.DepartmentVO;
import com.example.demo.vo.Employee;


@Service
@Component
public class DepartmentService implements DepartmentImpl {

	@Autowired
	DepartmentRepository departmentRepository;
	
	
@Autowired
	RestTemplate restTemp; 
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		int id = departmentRepository.findAll().size() + 1;
		department.setId(id);
		departmentRepository.save(department);
		return department;
	}
@Override
	public List<Department> addList(List<Department> department) {
		departmentRepository.saveAll(department);
		return department;
	}
	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);
		return department;
	}

	@Override
	public List<DepartmentVO> EmployeeforParticulardepartment(String name) {
		// TODO Auto-generated method stub
 List<DepartmentVO> fulllist = this.getAllDepartments().stream().map(p -> {
			Department colg = p; 
			List<Employee> slist = Arrays.asList(
					restTemp.getForEntity("http://EMPLOYEE-SERVICE/employee/"+ colg.getId() +"/" + name, Employee[].class).getBody());
			return new DepartmentVO(colg, slist);
		}).collect(Collectors.toList());
		return fulllist;	}

	@Override
	public AddResponse deleteDepartment(int id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Department Deleted...");
		return res;
	}

}