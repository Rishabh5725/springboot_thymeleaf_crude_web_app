package com.spring_project.springboot_thymeleaf_crude_web_app.service;

import com.spring_project.springboot_thymeleaf_crude_web_app.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeByID(long id);

    void deleteEmployeeById(long id);

    Page<Employee> findPaginated (int pageNo,int pageSize);

}
