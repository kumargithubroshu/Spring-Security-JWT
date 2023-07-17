package com.example.BlogMode.controller;

import com.example.BlogMode.model.Employee;
import com.example.BlogMode.service.Impl.EmployeeServiceImpl;
import com.example.BlogMode.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile multipartFile)
    {
        if(ExcelHelper.checkExcelFormat(multipartFile)) {
            employeeService.save(multipartFile);
            return new ResponseEntity<>("file uploaded successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("please upload accurate file",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public List<Employee> getAllDetails()
    {
        return employeeService.getAllEmployee();
    }
}
