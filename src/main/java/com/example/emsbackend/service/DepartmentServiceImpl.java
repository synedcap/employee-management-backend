package com.example.emsbackend.service;

import com.example.emsbackend.dto.DepartmentDto;
import com.example.emsbackend.entity.Department;
import com.example.emsbackend.mapper.DepartmentMapper;
import com.example.emsbackend.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return  DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
