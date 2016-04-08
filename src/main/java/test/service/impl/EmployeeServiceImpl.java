package test.service.impl;

import test.dao.EmployeeDAO;
import test.dao.impl.EmployeeDAOImpl;
import test.entity.Employee;
import test.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 06.04.16.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Employee getByEmail(String email) throws SQLException {
        return employeeDAO.getByEmail(email);
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return employeeDAO.getAll();
    }

    @Override
    public void addEmpl(Employee employee) throws SQLException {
        employeeDAO.addEmpl(employee);
    }

    @Override
    public void updateEmpl(Employee employee) throws SQLException {
        employeeDAO.updateEmpl(employee);
    }

    @Override
    public void delEmpl(Integer id) throws SQLException {
        employeeDAO.delEmpl(id);
    }

    @Override
    public List<Employee> getEmplByDepId(Integer id) throws SQLException {
        return employeeDAO.getEmplByDepId(id);
    }
}
