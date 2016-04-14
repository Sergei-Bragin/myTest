package test.service;

import org.springframework.transaction.annotation.Transactional;
import test.entity.Department;
import test.exception.ValidException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 04.04.16.
 */

public interface DepartmentService {

    Department getById(Integer id);
    Department getByName(String email);
    List<Department> getAll();
    void updateDep(Department department) throws ValidException;
    void delDep(Integer id);

}
