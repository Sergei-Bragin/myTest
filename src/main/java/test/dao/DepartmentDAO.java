package test.dao;

import test.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface DepartmentDAO {

    Department getById(Integer id)throws SQLException;
    Department getByName(String name)throws SQLException;
    List<Department> getAll()throws SQLException;
    void addDep(Department department)throws SQLException;
    void updateDep(Department department)throws SQLException;
    void delDep(Integer id)throws SQLException;

}
