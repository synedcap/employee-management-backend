package com.example.emsbackend.controller;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build add employee Rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //get specific employee from id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {

        EmployeeDto employeeDto =  employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDto);
    }

    //get all employees api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

        List<EmployeeDto> employees =  employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }


    //update employee api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody  EmployeeDto updatedEmployee) {

        EmployeeDto employeeDto =   employeeService.updateEmployee(employeeId,updatedEmployee);
        return  ResponseEntity.ok(employeeDto);
    }

    //delete employee api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("Employee deleted successfully!");
    }


}
