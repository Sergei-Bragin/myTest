package test.controller;

import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 04.04.16.
 */
public class DepartmentsShowAllController implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("deps", departmentService.getAll());
            request.getRequestDispatcher("WEB-INF/pages/dep/test.jsp").forward(request, response);
        } catch (SQLException e) {
            response.sendRedirect("/error");
        }
    }
}
