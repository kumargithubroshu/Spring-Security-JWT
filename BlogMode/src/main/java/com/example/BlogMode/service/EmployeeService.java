package com.example.BlogMode.service;

import com.example.BlogMode.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {

    public void save(MultipartFile multipartFile);

    public List<Employee> getAllEmployee();
}
