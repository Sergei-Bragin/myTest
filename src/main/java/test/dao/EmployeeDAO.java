package test.dao;

import test.entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface EmployeeDAO {

     Employee getById(Integer id );
     Employee getByEmail(String name );
     List<Employee> getAll();
     void updateEmpl(Employee employee);
     void delEmpl(Integer id);
     List<Employee> getEmplByDepId(Integer id);
}
