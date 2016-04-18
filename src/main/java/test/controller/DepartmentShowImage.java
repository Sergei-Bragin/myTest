package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Department;
import test.service.DepartmentService;
import test.util.ParseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by on 18.04.16.
 */
@Component("/showDepImage")
public class DepartmentShowImage implements InternalController {

    @Autowired
    DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Department department = departmentService.getById(ParseType.parseStringToInteger(request.getParameter("idImage")));
            byte[] image = department.getIcon();
            response.setContentType("image/jpeg");
            response.getOutputStream().write(image);

    }
}
