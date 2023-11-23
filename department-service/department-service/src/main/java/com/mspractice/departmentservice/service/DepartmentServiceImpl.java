package com.mspractice.departmentservice.service;



import org.springframework.stereotype.Service;

import com.mspractice.departmentservice.Dto.DepartmentDto;
import com.mspractice.departmentservice.entity.Department;
import com.mspractice.departmentservice.mapper.DepartmentMapper;
import com.mspractice.departmentservice.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}