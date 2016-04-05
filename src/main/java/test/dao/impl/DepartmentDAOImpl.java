package test.dao.impl;

import test.dao.DepartmentDAO;
import test.entity.Department;
import test.util.MYSQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    public Department getById(Integer id) {
        Department dep = new Department();
        try(Connection connection = MYSQLConnection.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement("select * from dep where id=?")) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    dep.setId(rs.getInt("id"));
                    dep.setName(rs.getString("name"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dep;
    }

    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery("select * from dep");
                while (rs.next()) {
                    Department dep = new Department();
                    dep.setId(rs.getInt("id"));
                    dep.setName(rs.getString("name"));
                    departments.add(dep);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public void addDep(Department department) {
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("insert into dep(name) values (?)")) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDep(Department department) {
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("update dep set name=? where id=?")) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.setInt(2, department.getId());
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delDep(Integer id) {
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from dep where id=?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
