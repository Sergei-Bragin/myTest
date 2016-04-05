package test.service;

import test.entity.Department;

import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface DepartmentService {

    Department getById(int id);
    List<Department> getAll();
    void addDep(Department department);
    void updateDep(Department department);
    void delDep(int id);

}
