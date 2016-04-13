package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by on 04.04.16.
 */
@Component("/")
public class DepartmentsShowAllController implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String forward = "WEB-INF/pages/dep/test.jsp";
            request.setAttribute("deps", departmentService.getAll());
            request.getRequestDispatcher(forward).forward(request, response);

    }
}
