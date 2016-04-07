package test.controller;

import test.entity.Department;
import test.exception.ValidException;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;
import test.util.ValidatorOVAL;

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
    private ValidatorOVAL oval = new ValidatorOVAL();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        Department department = new Department();
        department.setName(request.getParameter("name"));
        String depId = request.getParameter("id");

            oval.valid(department);
            if(depId.isEmpty()){
                departmentService.addDep(department);

            }else {
                department.setId(Integer.valueOf(depId));
                departmentService.updateDep(department);
            }
            response.sendRedirect("/");
        }catch (SQLException e){

        }
        catch (ValidException exception){
            Map<String,String> map =  exception.getMapError();
            request.setAttribute("error", map);
            request.getRequestDispatcher("WEB-INF/pages/dep/add.jsp").forward(request,response);
        }

    }
}
