package test.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Employee;
import test.service.EmployeeService;
import test.util.ParseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Component("/showDepEmpl")
public class DepartmentShowEmplList implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer depId = Integer.parseInt(request.getParameter("id"));

        if(depId != null){
            List <Employee> employees = employeeService.getEmplByDepId(depId);

            Gson gson = new GsonBuilder().setDateFormat("mm-dd-yyyy").create();
            String json = gson.toJson(employees);

            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
         }

    }

}
