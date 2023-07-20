package com.example.emsbackend.controller;

import com.example.emsbackend.dto.DepartmentDto;
import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    // add department
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody  DepartmentDto departmentDto){

        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
}
