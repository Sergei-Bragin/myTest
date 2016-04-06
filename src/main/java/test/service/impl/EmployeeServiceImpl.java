package test.service.impl;

import test.dao.EmployeeDAO;
import test.dao.impl.EmployeeDAOImpl;
import test.entity.Employee;
import test.service.EmployeeService;

import java.util.List;

/**
 * Created by on 06.04.16.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Employee getById(Integer id) {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public void addEmpl(Employee employee) {
        employeeDAO.addEmpl(employee);
    }

    @Override
    public void updateEmpl(Employee employee) {
        employeeDAO.updateEmpl(employee);
    }

    @Override
    public void delEmpl(Integer id) {
        employeeDAO.delEmpl(id);
    }

    @Override
    public List<Employee> getEmplByDepId(Integer id) {
        return employeeDAO.getEmplByDepId(id);
    }
}
