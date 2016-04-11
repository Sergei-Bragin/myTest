package test.controller;

import test.entity.Employee;
import test.exception.ValidException;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;
import test.util.ParseType;
import test.util.validation.ValidatorOVAL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by on 06.04.16.
 */
public class EmployeeAddController implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setSalary(ParseType.parseStringToDouble(request.getParameter("salary")));
        employee.setDate(ParseType.parseStringToDate(request.getParameter("date")));
        Integer depId = ParseType.parseStringToInteger(request.getParameter("idDep"));
        employee.setDepId(depId);
        String idEmpl = request.getParameter("idEmp");

        try {

            if (idEmpl.isEmpty()){
                employeeService.addEmpl(employee);
            }else{
                employee.setId(ParseType.parseStringToInteger(idEmpl));
                employeeService.updateEmpl(employee);
            }
            String url = "/showDepEmpl?id=" + depId;
            response.sendRedirect(url);
        }catch (SQLException e){
            response.sendRedirect("/error");
        }catch (ValidException exception){
            Map<String,String> map = exception.getMapError();
            request.setAttribute("error", map);
            request.setAttribute("empl", employee);
            request.getRequestDispatcher("WEB-INF/pages/empl/add.jsp").forward(request,response);
        }

    }
}
