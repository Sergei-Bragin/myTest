package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by on 05.04.16.
 */
@Component("/delDep")
public class DepartmentsDelController implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer depId = Integer.parseInt(request.getParameter("id"));
            departmentService.delDep(depId);
            response.sendRedirect("/");

        }catch (SQLException e){
            response.sendRedirect("/error");
        }

    }
}
