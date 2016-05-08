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

        String name = request.getParameter("name");
        String value = request.getParameter("id");
        Integer id = null      ;
        if (!value.equals("")) {
            id = Integer.parseInt(value);
        }

        Department dep = departmentService.getByName(name);

        if(name.equals(dep.getName())){
            if(id == null){
                response.getWriter().write("false");
            }else if(id != dep.getId().intValue()){
                response.getWriter().write("false");
            } else response.getWriter().write("true");
        } else response.getWriter().write("true");
    }
}
