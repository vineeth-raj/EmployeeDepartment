package com.example.demo.entity;

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
@Table(name="Department")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {

private int noofemp;
	

private String name;
	

@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	
}