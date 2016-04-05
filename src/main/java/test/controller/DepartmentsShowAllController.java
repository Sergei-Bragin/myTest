package test.controller;

import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 04.04.16.
 */
public class DepartmentsShowAllController implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "WEB-INF/pages/dep/test.jsp";
        request.setAttribute("deps", departmentService.getAll());
        request.getRequestDispatcher(forward).forward(request, response);
    }
}
