package test.controller;

import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by on 06.04.16.
 */
public class EmployeeAddController implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setSalary(Double.valueOf(request.getParameter("salary")));
        employee.setDate(Date.valueOf(request.getParameter("date")));
        String s = request.getParameter("idDep");
        employee.setDepId(Integer.valueOf(request.getParameter("idDep")));

        String idEmpl = request.getParameter("id");
        if (idEmpl.isEmpty()){
            employeeService.addEmpl(employee);
        }else{
            employee.setId(Integer.valueOf(idEmpl));
            employeeService.updateEmpl(employee);
        }
        response.sendRedirect("/");

    }
}
