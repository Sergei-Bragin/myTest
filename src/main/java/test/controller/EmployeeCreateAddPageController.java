package test.controller;

import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 06.04.16.
 */
public class EmployeeCreateAddPageController implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if(id!=null){
            Integer depId = Integer.valueOf(id);
            Employee employee = employeeService.getById(Integer.valueOf(depId));
            request.setAttribute("id_dep", depId);
            if(employee!=null){
                request.setAttribute("empl",employee);
            }
        }
        request.getRequestDispatcher("WEB-INF/pages/empl/add.jsp").forward(request, response);

    }
}
