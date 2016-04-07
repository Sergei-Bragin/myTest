package test.controller;

import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by on 06.04.16.
 */
public class EmployeeAddController implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Employee employee = new Employee();
            employee.setName(request.getParameter("name"));
            employee.setEmail(request.getParameter("email"));
            employee.setSalary(Double.valueOf(request.getParameter("salary")));
            employee.setDate(Date.valueOf(request.getParameter("date")));
            Integer depId = Integer.valueOf(request.getParameter("idDep"));
            employee.setDepId(depId);
            String idEmpl = request.getParameter("idEmp");

            if (idEmpl.isEmpty()){
                employeeService.addEmpl(employee);
            }else{
                employee.setId(Integer.valueOf(idEmpl));
                employeeService.updateEmpl(employee);
            }
            String url = "/showDepEmpl?id=" + depId;
            response.sendRedirect(url);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
