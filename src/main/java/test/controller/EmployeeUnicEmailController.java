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
 * Created by on 06.05.16.
 */
@Component("/unicEmplEmail")
public class EmployeeUnicEmailController implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String value = request.getParameter("id");
        Integer id = null;
        if(!value.equals("")){
            id=Integer.parseInt(value);
        }

        Employee emp = employeeService.getByEmail(email);

        if(email.equals(emp.getEmail())){
            if(id==null){
                response.getWriter().write("false");
            }else if (id != emp.getId().intValue()){
                response.getWriter().write("false");
            }else response.getWriter().write("true");
        }else response.getWriter().write("true");

    }
}
