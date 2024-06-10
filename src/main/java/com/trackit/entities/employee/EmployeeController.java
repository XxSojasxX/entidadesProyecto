package com.trackit.entities.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trackit/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    //Create
    @PostMapping
    public Employee employeeSave (@RequestBody Employee entity)
    {
        return employeeService.employeeSave(entity);
    }

    //Select
    @GetMapping("/{id}/")
    public Employee employeeFindById(@PathVariable Long id)
    {
        return employeeService.employeeFindById(id);
    }

    //Select All
    @GetMapping
    public List<Employee> employeeFindAll(){
        return employeeService.employeeFindAll();
    }

    //Update
    @PutMapping("/update/{id}/")
    public Employee employeeUpdate(@RequestBody Employee entity)
    {
        return employeeService.employeeSave(entity);
    }

    //DeleteMapping
    @DeleteMapping("/{id}/")
    public void employeeDelete(@PathVariable Long id){
        employeeService.employeeDeleteById(id);
    }

}
