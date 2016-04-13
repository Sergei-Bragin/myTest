package test.service.impl;

import test.dao.EmployeeDAO;
import test.dao.impl.EmplDAOImpl;
import test.entity.Employee;
import test.exception.ValidException;
import test.service.EmployeeService;
import test.util.validation.ValidatorOVAL;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 06.04.16.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmplDAOImpl();
    private ValidatorOVAL validatorOVAL = new ValidatorOVAL();

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
    public void updateEmpl(Employee employee) throws SQLException, ValidException {
        validatorOVAL.valid(employee);
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
