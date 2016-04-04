package test.dao;

import test.entity.Department;

import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface DepartmentDAO {

    Department readDepartmentByID(int id);
    List<Department> readDepartments();
    void createDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int id);

}
