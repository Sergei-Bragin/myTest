package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Employee;
import test.exception.ValidException;
import test.service.EmployeeService;
import test.util.ParseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by on 06.04.16.
 */
@Component("/saveEmpl")
public class EmployeeAddController implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setSalary(ParseType.parseStringToDouble(request.getParameter("salary")));
        employee.setDate(ParseType.parseStringToDate(request.getParameter("date")));
        Integer depId = ParseType.parseStringToInteger(request.getParameter("depId"));
        employee.setDepId(depId);
        String idEmpl = request.getParameter("id");

        try {

            if (idEmpl.isEmpty()) {
                employeeService.updateEmpl(employee);
            } else {
                employee.setId(ParseType.parseStringToInteger(idEmpl));
                employeeService.updateEmpl(employee);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (ValidException exception) {
            Map<String, String> map = exception.getMapError();
            request.setAttribute("error", map);
            request.setAttribute("empl", employee);
            request.getRequestDispatcher("WEB-INF/pages/empl/add.jsp").forward(request, response);
        }

    }
}
