package test.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {

    private ControllerFactory controllerFactory = new ControllerFactory();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String controllerAction = req.getRequestURI();

        InternalController controller = controllerFactory.getControllerByName(controllerAction);
        if (controller == null) {
            controller = controllerFactory.getDefaultController();
        }
        controller.execute(req, resp);
    }
}
