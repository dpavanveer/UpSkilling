package com.mspractice.departmentservice.service;

import com.mspractice.departmentservice.Dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}