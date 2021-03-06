package test.controller;

import test.entity.Department;
import test.exception.ValidException;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;
import test.util.validation.ValidatorOVAL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

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
        try {
            if(depId.isEmpty()){
                departmentService.addDep(department);
            }else {
                department.setId(Integer.valueOf(depId));
                departmentService.updateDep(department);
            }
            response.sendRedirect("/");
        }catch (SQLException e){
            response.sendRedirect("/error");
        }
        catch (ValidException exception){
            Map<String,String> map =  exception.getMapError();
            request.setAttribute("error", map);
            request.setAttribute("department", department);
            request.getRequestDispatcher("WEB-INF/pages/dep/add.jsp").forward(request,response);
        }

    }
}
