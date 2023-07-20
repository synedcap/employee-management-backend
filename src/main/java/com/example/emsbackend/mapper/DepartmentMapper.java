package com.example.emsbackend.mapper;

import com.example.emsbackend.dto.DepartmentDto;
import com.example.emsbackend.entity.Department;

public class DepartmentMapper {

    //convert department jpa into department dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        return  new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()

        );
    };

    //convert department dto into jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return  new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()

        );
    };
}
