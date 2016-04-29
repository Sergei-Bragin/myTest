package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import test.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 05.04.16.
 */
@Component("/delDep")
public class DepartmentsDelController implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer depId = Integer.parseInt(request.getParameter("id"));
        departmentService.delDep(depId);
        response.sendRedirect("/");

    }
}
