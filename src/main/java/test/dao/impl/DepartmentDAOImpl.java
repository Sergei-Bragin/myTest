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

    @Override
    public Department getByName(String name) throws SQLException {
        Department dep = new Department();
        try (Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from dep where name=?")) {
                preparedStatement.setString(1, name);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    dep.setId(rs.getInt("id"));
                    dep.setName(rs.getString("name"));
                    dep.setIcon(rs.getBytes("icon"));
                }
            }
        }
        return dep;
    }

    @Override
    public Department getById(Integer id) throws SQLException {

        Department dep = new Department();
        try (Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from dep where id=?")) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    dep.setId(rs.getInt("id"));
                    dep.setName(rs.getString("name"));
                    dep.setIcon(rs.getBytes("icon"));
                }
            }
        }
        return dep;
    }

    @Override
    public List<Department> getAll() throws SQLException {

        List<Department> departments = new ArrayList<>();
        try (Connection connection = MYSQLConnection.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery("select * from dep");
                while (rs.next()) {
                    Department dep = new Department();
                    dep.setId(rs.getInt("id"));
                    dep.setName(rs.getString("name"));
                    dep.setIcon(rs.getBytes("icon"));
                    departments.add(dep);
                }
            }
        }
        return departments;
    }

    @Override
    public void addDep(Department department) throws SQLException {

        try (Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("insert into dep(name,icon) values (?,?)")) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.setBytes(2, department.getIcon());
                preparedStatement.executeUpdate();
            }
        }

    }

    @Override
    public void updateDep(Department department) throws SQLException {

        try (Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("update dep set name=?,icon=? where id=?")) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.setBytes(2, department.getIcon());
                preparedStatement.setInt(3, department.getId());
                preparedStatement.executeUpdate();
            }
        }
    }

    @Override
    public void delDep(Integer id) throws SQLException {

        try (Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from dep where id=?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        }

    }
}
