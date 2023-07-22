package com.example.emsbackend.controller;

import com.example.emsbackend.dto.DepartmentDto;
import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    //get specific department from id
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {

        DepartmentDto departmentDto =  departmentService.getDepartmentById(departmentId);
        return  ResponseEntity.ok(departmentDto);
    }

    //get all departments api
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

        List<DepartmentDto> departments =  departmentService.getAllDepartments();
        return  ResponseEntity.ok(departments);
    }

    //update department api
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                      @RequestBody  DepartmentDto updatedDepartment) {

        DepartmentDto departmentDto =   departmentService.updateDepartment(departmentId,updatedDepartment);
        return  ResponseEntity.ok(departmentDto);
    }


    //delete employee api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {

        departmentService.deleteDepartment(departmentId);
        return  ResponseEntity.ok("Department deleted successfully!");
    }
}
