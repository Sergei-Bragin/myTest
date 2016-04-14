package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Employee;
import test.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 06.04.16.
 */
@Component("/addEmpl")
public class EmployeeCreateAddPageController implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("idEmp");
        if (id != null) {
            Integer depId = Integer.valueOf(id);
            Employee employee = employeeService.getById(Integer.valueOf(depId));
            if (employee != null) {
                request.setAttribute("empl", employee);
            }
        }
        request.setAttribute("id_dep", request.getParameter("id"));
        request.getRequestDispatcher("WEB-INF/pages/empl/add.jsp").forward(request, response);


    }
}
