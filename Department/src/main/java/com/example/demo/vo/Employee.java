package com.example.demo.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

private String gender;
	

private String dateofjoining;
	

private int departmentid;
	

private String name;
	

@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

private int salary;
	

private int age;
	

	
	
}