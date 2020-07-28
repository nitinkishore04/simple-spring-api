package in.nitin.springboot.springbootapi.controller;

import in.nitin.springboot.springbootapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import in.nitin.springboot.springbootapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    public List<Employee> get(){
        return employeeService.get();
    }

    @PostMapping("/emp")
    public Employee save(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @GetMapping("/emp/{id}")
    public Employee get(@PathVariable int id) {
        Employee employee = employeeService.get(id);
        if(employee == null){
            throw new RuntimeException("\nEmployee with id: "+id+" doesn't exist.\n");
        }
        else
            return employee;
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable int id) {
        try{
            employeeService.delete(id);
            return "Employee wid id: "+id+" has been deleted.";
        }
        catch (Exception e)
        {
            return String.valueOf(e);
        }
    }

    @PutMapping("/emp")
    public Employee update(@RequestBody Employee employee){
        try{
            employeeService.save(employee);
            return employee;
        }
        catch (Exception e) {
            throw new RuntimeException("\nEmployee doesn't exist\n");
        }
    }
}
