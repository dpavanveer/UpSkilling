package com.angular.connection.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	
	@Id
	private int id;
    private String name;
    private String address;
    private double salary;
	public int getStudentName() {
		// TODO Auto-generated method stub
		return 0;
	}

}
