package test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public interface DepartmentDAO {

    Department getById(Integer id);
    Department getByName(String name);
    List<Department> getAll();
    void updateDep(Department department);
    void delDep(Integer id);

}
