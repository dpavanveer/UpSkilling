package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DepartmentDto;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/add")
	public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto deptdto)
	{
		DepartmentDto saved=service.create(deptdto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getbycode/{code}")
	public ResponseEntity<DepartmentDto> getbycode(@PathVariable String code)
	{
		DepartmentDto saved=service.getBycode(code);
		return new ResponseEntity<>(saved,HttpStatus.OK);
	}

}
