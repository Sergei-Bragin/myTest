package test.service.impl;

import test.dao.DepartmentDAO;
import test.dao.EmployeeDAO;
import test.dao.impl.DepartmentDAOImpl;
import test.dao.impl.EmployeeDAOImpl;
import test.entity.Department;
import test.entity.Employee;
import test.service.DepartmentService;
import test.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Department getById(Integer id) {
        return departmentDAO.getById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }

    @Override
    public void addDep(Department department) {
        departmentDAO.addDep(department);
    }

    @Override
    public void updateDep(Department department) {
        departmentDAO.updateDep(department);
    }

    @Override
    public void delDep(Integer id) {
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
