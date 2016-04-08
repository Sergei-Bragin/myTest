package test.service;

import test.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface DepartmentService {

    Department getById(Integer id)throws SQLException;
    Department getByName(String email)throws SQLException;
    List<Department> getAll()throws SQLException;
    void addDep(Department department)throws SQLException;
    void updateDep(Department department)throws SQLException;
    void delDep(Integer id) throws SQLException;

}
