package com.example.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;
import com.example.repo.DepartmentRepo;
import com.example.service.DepartmentService;

@Service
public class DepartmentImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public DepartmentDto create(DepartmentDto departmentdto)
	{
		Department dept=modelmapper.map(departmentdto,Department.class);
		Department saved = repo.save(dept);
		 DepartmentDto dto=modelmapper.map(saved, DepartmentDto.class);
		return dto;
	}

	@Override
	public DepartmentDto getBycode(String code) {
		
		
		Department saved=repo.findByCode(code);
		DepartmentDto dto=modelmapper.map(saved, DepartmentDto.class);
		return dto;
	}

}
