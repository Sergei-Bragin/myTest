package test.dao;

import test.entity.Department;

import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface DepartmentDAO {

    Department getById(Integer id);
    List<Department> getAll();
    void addDep(Department department);
    void updateDep(Department department);
    void delDep(Integer id);

}
