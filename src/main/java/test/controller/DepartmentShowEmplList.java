package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Department;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;
import test.util.ParseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by on 06.04.16.
 */
@Component("/showDepEmpl")
public class DepartmentShowEmplList implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            if(id!=null){
                Integer depId = ParseType.parseStringToInteger(id);
                List<Employee> employees = employeeService.getEmplByDepId(Integer.valueOf(depId));
                if(employees!=null){
                    request.setAttribute("id_dep",depId);
                    request.setAttribute("empls",employees);
                }
            }
            request.getRequestDispatcher("WEB-INF/pages/empl/showEmp.jsp").forward(request, response);
        }catch (SQLException e){
            response.sendRedirect("/error");
        }

    }

}
