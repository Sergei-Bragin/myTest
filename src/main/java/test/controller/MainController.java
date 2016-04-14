package test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component(value = "MainController")
public class MainController implements HttpRequestHandler {

    @Autowired
    private Map<String, InternalController> controllerFactory;

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String requestURI = httpServletRequest.getRequestURI();
        InternalController internalController = controllerFactory.get(requestURI);
        internalController.execute(httpServletRequest, httpServletResponse);
    }
}
