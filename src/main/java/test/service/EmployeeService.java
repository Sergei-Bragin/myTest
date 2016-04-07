package test.service;

import test.entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 06.04.16.
 */
public interface EmployeeService {
    Employee getById(Integer id) throws SQLException;
    List<Employee> getAll() throws SQLException;
    void addEmpl(Employee employee) throws SQLException;
    void updateEmpl(Employee employee) throws SQLException;
    void delEmpl(Integer id) throws SQLException;
    List<Employee> getEmplByDepId(Integer id) throws SQLException;
}
