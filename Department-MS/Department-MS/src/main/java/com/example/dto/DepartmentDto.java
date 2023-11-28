package com.example.dto;


public class DepartmentDto {
	

	
	private Long id;
	
	private String department_name;

	private String description;

	private String code;
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DepartmentDto(Long id, String department_name, String description, String code) {
		super();
		this.id = id;
		this.department_name = department_name;
		this.description = description;
		this.code = code;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}

