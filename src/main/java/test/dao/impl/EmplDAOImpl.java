package test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.util.ParseType;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by on 12.04.16.
 */
@Repository
public class EmplDAOImpl implements EmployeeDAO {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Employee getById(Integer id) {
        String query = "select * from empl where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Employee employee = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDate(resultSet.getDate("date"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepId(resultSet.getInt("id_dep"));
                return employee;
            }
        });
        return employee;
    }

    @Override
    public Employee getByEmail(String email) {
        String query = "select * from empl where email=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Employee empl = jdbcTemplate.queryForObject(query, new Object[]{email}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee empl = new Employee();
                empl.setId(resultSet.getInt("id"));
                empl.setSalary(resultSet.getDouble("salary"));
                empl.setDepId(resultSet.getInt("id_dep"));
                empl.setName(resultSet.getString("name"));
                empl.setEmail(resultSet.getString("email"));
                empl.setDate(resultSet.getDate("date"));
                return empl;
            }
        });
        return empl;
    }

    @Override
    public List<Employee> getAll() {
        String query = "select * from empl";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Employee> emplList = new ArrayList<>();

        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        for (Map<String, Object> empRow : empRows){
            Employee employee = new Employee();
            employee.setDate(ParseType.parseStringToDate(String.valueOf(empRow.get("date"))));
            employee.setName(String.valueOf(empRow.get("name")));
            employee.setEmail(String.valueOf(empRow.get("email")));
            employee.setSalary(ParseType.parseStringToDouble(String.valueOf(empRow.get("salary"))));
            employee.setId(ParseType.parseStringToInteger(String.valueOf(empRow.get("id"))));
            employee.setDepId(ParseType.parseStringToInteger(String.valueOf(empRow.get("id_dep"))));
            emplList.add(employee);
        }
        return emplList;
    }

    @Override
    public void updateEmpl(Employee empl) {
        String query;
        if(empl.getId()!=null){
            query = "update empl set name = ?, email = ?, date = ?, salary = ?, id_dep = ?  where id = ?";
        }else query = "insert into empl (name, email, date, salary, id_dep, id) values(?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{empl.getName(), empl.getEmail(),empl.getDate(),empl.getSalary(),empl.getDepId(),empl.getId()};
        jdbcTemplate.update(query,args);
    }

    @Override
    public void delEmpl(Integer id) {
        String query = "delete from empl where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(query,id);
    }

    @Override
    public List<Employee> getEmplByDepId(Integer idDep) {
        List<Employee> emplList = getAll();
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee : emplList){
            if (employee.getDepId() == idDep){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}
