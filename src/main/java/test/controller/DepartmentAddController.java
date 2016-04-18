package test.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.Department;
import test.exception.ValidException;
import test.service.DepartmentService;
import test.util.ParseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by on 05.04.16.
 */
@Component("/saveDep")
public class DepartmentAddController implements InternalController {

    @Autowired
    private DepartmentService departmentService;


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(request)) {
            Department department = new Department();
            try {
                List<FileItem> list = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : list) {
                    if (item.getFieldName().equals("id")) {
                        String id = new String(item.get(), "UTF-8");
                        department.setId(ParseType.parseStringToInteger(id));
                    } else if (item.getFieldName().equals("name")) {
                        String name = new String(item.get(), "UTF-8");
                        department.setName(name);
                    } else if (item.getFieldName().equals("icon")) {
                        department.setIcon(item.get());
                    }
                }
                if (department.getId() == null) {
                    departmentService.updateDep(department);
                } else {
                    departmentService.updateDep(department);
                }
                response.sendRedirect("/");
            } catch (ValidException exception) {
                Map<String, String> map = exception.getMapError();
                request.setAttribute("error", map);
                request.setAttribute("department", department);
                request.getRequestDispatcher("WEB-INF/pages/dep/add.jsp").forward(request, response);
            } catch (Exception ex) {
                response.sendRedirect("/error");
            }
        }


    }
}
