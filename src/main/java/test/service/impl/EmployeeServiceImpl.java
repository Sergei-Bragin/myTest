package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.exception.ValidException;
import test.service.EmployeeService;
import test.util.validation.ValidatorOVAL;

import java.util.List;

/**
 * Created by on 06.04.16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ValidatorOVAL validatorOVAL;

    @Override
    public Employee getByEmail(String email) {
        return employeeDAO.getByEmail(email);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public void updateEmpl(Employee employee) throws ValidException {
        validatorOVAL.valid(employee);
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
