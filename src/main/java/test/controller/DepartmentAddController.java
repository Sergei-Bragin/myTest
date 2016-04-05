package test.controller;

import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 05.04.16.
 */
public class DepartmentAddController implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();
        department.setName(request.getParameter("name"));
        String depId = request.getParameter("id");
        if(depId ==null || depId.isEmpty()){
            departmentService.addDep(department);

        }else {
            department.setId(Integer.valueOf(depId));
            departmentService.updateDep(department);
        }
        response.sendRedirect("/");
    }
}
