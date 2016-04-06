package test.controller;

import test.entity.Department;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by on 06.04.16.
 */
public class DepartmentShowEmplList implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id!=null){
            Integer depId = Integer.valueOf(id);
            List<Employee> employees = employeeService.getEmplByDepId(Integer.valueOf(depId));
            if(employees!=null){
                request.setAttribute("id_dep",depId);
                request.setAttribute("empls",employees);
            }
        }
        request.getRequestDispatcher("WEB-INF/pages/empl/showEmp.jsp").forward(request, response);
    }

}
