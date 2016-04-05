package test.controller;

import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 05.04.16.
 */
public class DelDepartmentsController implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int depId = Integer.parseInt(request.getParameter("id"));
        departmentService.delDep(depId);
        String forward = "WEB-INF/pages/dep/test.jsp";
        request.setAttribute("deps", departmentService.getAll());
        request.getRequestDispatcher(forward).forward(request, response);
    }


    @Override
    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
