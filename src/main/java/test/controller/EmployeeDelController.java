package test.controller;

import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by on 06.04.16.
 */

public class EmployeeDelController implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Integer id = Integer.parseInt((request.getParameter("id")));
            Integer depId = Integer.parseInt((request.getParameter("depId")));
            employeeService.delEmpl(id);
            String url = "/showDepEmpl?id=" + depId;
            response.sendRedirect(url);
        }catch (SQLException e){

        }
    }
}

