package test.service.impl;

import test.dao.DepartmentDAO;
import test.dao.EmployeeDAO;
import test.dao.impl.DepDAOImpl;

import test.dao.impl.EmplDAOImpl;

import test.entity.Department;
import test.entity.Employee;
import test.exception.ValidException;
import test.service.DepartmentService;
;
import test.util.validation.ValidatorOVAL;

import java.sql.SQLException;

import java.util.List;

/**
 * Created by on 04.04.16.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAO departmentDAO = new DepDAOImpl();
    private EmployeeDAO employeeDAO = new EmplDAOImpl();
    private ValidatorOVAL validatorOVAL = new ValidatorOVAL();

    @Override
    public Department getByName(String name) throws SQLException {
        return departmentDAO.getByName(name);
    }

    @Override
    public Department getById(Integer id) throws SQLException {
        return departmentDAO.getById(id);
    }

    @Override
    public List<Department> getAll() throws SQLException {
        return departmentDAO.getAll();
    }
    @Override
    public void updateDep(Department department) throws SQLException, ValidException {
        validatorOVAL.valid(department);
        departmentDAO.updateDep(department);
    }

    @Override
    public void delDep(Integer id) throws SQLException {
        List<Employee> employees = employeeDAO.getEmplByDepId(id);
        if(!employees.isEmpty()){
            for(Employee emp : employees){
                employeeDAO.delEmpl(emp.getId());
            }
            departmentDAO.delDep(id);
        }else {
            departmentDAO.delDep(id);
        }
    }

}
