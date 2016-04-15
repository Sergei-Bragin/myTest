package test.controller;

import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;
import test.util.ParseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by on 15.04.16.
 */
public class ImagePage implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Department department = departmentService.getById(ParseType.parseStringToInteger(request.getParameter("idImage")));
            byte[] image = department.getIcon();
            response.setContentType("image/jpeg");
            response.getOutputStream().write(image);
        } catch (SQLException e) {
            response.sendRedirect("/error");
        }

    }
}
