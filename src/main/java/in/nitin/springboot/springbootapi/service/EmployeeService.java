package in.nitin.springboot.springbootapi.service;

import in.nitin.springboot.springbootapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> get();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);
}
