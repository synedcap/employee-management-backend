package com.example.emsbackend.service;

import com.example.emsbackend.dto.DepartmentDto;
import com.example.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto  getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId,DepartmentDto updatedDepartment);

    void deleteDepartment(Long departmentId);
}
