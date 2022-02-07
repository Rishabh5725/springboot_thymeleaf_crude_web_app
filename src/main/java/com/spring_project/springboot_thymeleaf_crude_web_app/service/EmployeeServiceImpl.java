package com.spring_project.springboot_thymeleaf_crude_web_app.service;

import com.spring_project.springboot_thymeleaf_crude_web_app.model.Employee;
import com.spring_project.springboot_thymeleaf_crude_web_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
     private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> optional=employeeRepository.findById(id);
        Employee employee=null;
        if (optional.isPresent()){
            employee=optional.get();
        }else{
            throw new RuntimeException("Employee is not found for id::::"+id);
        }

        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return this.employeeRepository.findAll(pageable);
    }
}
