package test.controller;

import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 06.04.16.
 */

public class EmployeeDelController implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt((request.getParameter("id")));
        Integer depId = Integer.parseInt((request.getParameter("depId")));

        employeeService.delEmpl(id);

        request.setAttribute("depId", request.getParameter("depId"));

        String url = "/showAllEmpl?depId=" + request.getParameter("depId");
        response.sendRedirect(url);
    }
}

/*Integer empId = Integer.parseInt(request.getParameter("id"));
        employeeService.delEmpl(empId);
        String forward = "WEB-INF/pages/empl/showEmp.jsp";
        request.setAttribute("d");
        *//*
*/
/*Integer depId = Integer.parseInt(request.getParameter("id"));
        departmentService.delDep(depId);
        String forward = "WEB-INF/pages/dep/test.jsp";
        request.setAttribute("deps", departmentService.getAll());
        request.getRequestDispatcher(forward).forward(request, response);*//*

           }
}
*/
