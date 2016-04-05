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
public class DepartmentCreateAddPageController implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id!=null){
            Integer depId = Integer.valueOf(id);
            Department department = departmentService.getById(Integer.valueOf(depId));
            if(department!=null){
                request.setAttribute("department",department);
            }
        }
        request.getRequestDispatcher("WEB-INF/pages/dep/add.jsp").forward(request, response);
    }
}
