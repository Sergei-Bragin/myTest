package test.dao.impl;

import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.util.MYSQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee getById(Integer id) {
        Employee employee = new Employee();
        try(Connection connection = MYSQLConnection.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement("select * from empl where id=?")) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setDate(rs.getDate("date"));
                    employee.setSalary(rs.getDouble("salary"));
                    employee.setDepId(rs.getInt("id_dep"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery("select * from empl");
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setDate(rs.getDate("date"));
                    employee.setSalary(rs.getDouble("salary"));
                    employee.setDepId(rs.getInt("id_dep"));
                    employees.add(employee);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void addEmpl(Employee employee) {
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("insert into empl (name, email, date, salary, department_id) values(?,?,?,?,?)")){
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getEmail());
                preparedStatement.setDate(3,  new java.sql.Date(employee.getDate().getTime()));
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setInt(5, employee.getDepId());
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmpl(Employee employee) {
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("update empl set name = ?, email = ?, date = ?, salary = ?,  where employees_id = ?")) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getEmail());
                preparedStatement.setDate(3, new java.sql.Date(employee.getDate().getTime()));
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.executeQuery();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delEmpl(Integer id) {
        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from empl where id=?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmplByDepId(Integer id) {

        List<Employee> employees = new ArrayList<Employee>();

        try(Connection connection = MYSQLConnection.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from empl where department_id = ?")) {

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet != null) {
                    while (resultSet.next()) {

                        Employee employee = new Employee();
                        employee.setId(resultSet.getInt("id"));
                        employee.setName(resultSet.getString("name"));
                        employee.setEmail(resultSet.getString("email"));
                        employee.setDate(resultSet.getDate("date"));
                        employee.setSalary(resultSet.getDouble("salary"));
                        employees.add(employee);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
