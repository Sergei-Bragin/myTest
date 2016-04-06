package test.service;

import test.entity.Employee;

import java.util.List;

/**
 * Created by on 06.04.16.
 */
public interface EmployeeService {
    Employee getById(Integer id );
    List<Employee> getAll();
    void addEmpl(Employee employee);
    void updateEmpl(Employee employee);
    void delEmpl(Integer id);
    List<Employee> getEmplByDepId(Integer id);
}
