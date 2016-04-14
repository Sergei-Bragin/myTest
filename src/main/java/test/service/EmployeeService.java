package test.service;

import org.springframework.transaction.annotation.Transactional;
import test.entity.Employee;
import test.exception.ValidException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 06.04.16.
 */

public interface EmployeeService {

    Employee getByEmail(String email);
    Employee getById(Integer id);
    List<Employee> getAll();
    void updateEmpl(Employee employee)throws ValidException;
    void delEmpl(Integer id);
    List<Employee> getEmplByDepId(Integer id);
}
