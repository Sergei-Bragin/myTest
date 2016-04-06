package test.dao;

import test.entity.Employee;

import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface EmployeeDAO {

     Employee getById(Integer id );
     List<Employee> getAll();
     void addEmpl(Employee employee);
     void updateEmpl(Employee employee);
     void delEmpl(Integer id);
     List<Employee> getEmplByDepId(Integer id);
}
