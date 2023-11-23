package com.mspractice.departmentservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="departments")
public class Department {

	@Id
	private long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
}
