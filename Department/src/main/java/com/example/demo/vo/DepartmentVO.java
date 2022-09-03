package com.example.demo.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.example.demo.entity.Department;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentVO {

private Department department;
	private List<Employee> employee;	
	
}