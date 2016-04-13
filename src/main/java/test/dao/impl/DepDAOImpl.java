package test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import test.dao.DepartmentDAO;
import test.entity.Department;
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
public class DepDAOImpl implements DepartmentDAO {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Department getById(Integer id){
        String query = "select id, name from dep where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Department dep =jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department dep  = new Department();
                dep.setId(resultSet.getInt("id"));
                dep.setName(resultSet.getString("name"));
                return dep;
            }
        });
        return dep;
    }

    @Override
    public Department getByName(String name){
        String query = "select id, name from dep where name=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Department dep =jdbcTemplate.queryForObject(query, new Object[]{name}, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName("name");
                return department;
            }
        });
        return dep;
    }

    @Override
    public List<Department> getAll(){
        String query = "select * from dep";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Department> depList = new ArrayList<>();

        List<Map<String,Object>> depRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> depRow : depRows){
            Department dep  = new Department();
            dep.setId(ParseType.parseStringToInteger(String.valueOf(depRow.get("id"))));
            dep.setName(String.valueOf(depRow.get("name")));
            depList.add(dep);
        }
        return depList;
    }

    @Override
    public void updateDep(Department department){
        String query;
        if (department.getId()!= null){
            query = "update dep set name=? where id=?";
        } else query = "INSERT  into dep (neme, id) VALUE (?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{department.getName(),department.getId()};
        jdbcTemplate.update(query,args);
    }

    @Override
    public void delDep(Integer id){
        String query = "delete from dep where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(query,id);
    }
}
