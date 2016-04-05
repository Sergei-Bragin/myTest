package test.service.impl;

import test.dao.DepartmentDAO;
import test.dao.impl.DepartmentDAOImpl;
import test.entity.Department;
import test.service.DepartmentService;

import java.util.List;

/**
 * Created by on 04.04.16.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public Department getById(int id) {
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
    public void delDep(int id) {
        departmentDAO.delDep(id);
    }

}
