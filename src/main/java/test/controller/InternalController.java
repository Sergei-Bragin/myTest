package test.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface InternalController {

    void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


}
