package in.nitin.springboot.springbootapi.dao;

import in.nitin.springboot.springbootapi.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> get();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);
}
