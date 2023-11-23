package com.mspractice.departmentservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.mspractice.departmentservice.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{
	 Department findByDepartmentCode(String departmentCode);
	

}
