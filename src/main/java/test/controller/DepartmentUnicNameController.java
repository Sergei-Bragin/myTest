package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Department;
import test.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 06.05.16.
 */
@Component("/unicDepName")
public class DepartmentUnicNameController implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        Integer id1 = null      ;
        if (!id.equals("")) {
            id1 = Integer.parseInt(id);
        }
        Department dep = departmentService.getByName(name);

        if (dep.getName() == null) {
            response.getWriter().write("true");
        } else if (dep.getId().intValue() == id1) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }

    }
}
