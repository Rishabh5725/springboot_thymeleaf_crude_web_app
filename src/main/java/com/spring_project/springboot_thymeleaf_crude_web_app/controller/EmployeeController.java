    package com.spring_project.springboot_thymeleaf_crude_web_app.controller;
    import com.spring_project.springboot_thymeleaf_crude_web_app.model.Employee;
    import com.spring_project.springboot_thymeleaf_crude_web_app.service.EmployeeService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    public class EmployeeController {

    //displays list of employees
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/add")
    public String viewHomePage( Model model){
    // displays list of the employee.
        return findPaginated(1,model);
    }
    @GetMapping("/showNewEmployeeForm")
    // create model attribute to bind form data.
    public  String showNewEmployeeForm(Model model){
    Employee employee=new Employee();
    model.addAttribute("employee",employee);
    return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
    // Save Employee to database
    employeeService.saveEmployee(employee);
    return "redirect:/add";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate (@PathVariable(value="id") Long id,Model model){

    //Get employee from the service
    Employee employee=employeeService.getEmployeeByID(id);

    //set employee as a model attribute to pre-populate the form
    model.addAttribute("employee",employee);
    return "update_employee";
    }
        @GetMapping("/deleteEmployee/{id}")
        public String deleteEmployee(@PathVariable(value = "id")long id){

        //call delete employee method
            this.employeeService.deleteEmployeeById(id);
            return "redirect:/add";
        }
        @GetMapping("/page/{pageNo}")
        public String findPaginated(@PathVariable(value = "pageNo")int pageNo,Model model){
        int pageSize=5;
            Page<Employee> page=employeeService.findPaginated(pageNo,pageSize);
            List<Employee> listEmployees=page.getContent();

            model.addAttribute("currentPage",pageNo);
            model.addAttribute("totalPages",page.getTotalPages());
            model.addAttribute("totalItems",page.getTotalElements());
            model.addAttribute("listEmployees",listEmployees);
            return "index";


        }

    }
