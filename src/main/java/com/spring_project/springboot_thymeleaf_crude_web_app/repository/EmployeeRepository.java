package com.spring_project.springboot_thymeleaf_crude_web_app.repository;

import com.spring_project.springboot_thymeleaf_crude_web_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>  {

}
