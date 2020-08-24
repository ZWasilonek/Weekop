package pl.javalearn.weekop.controller;

import pl.javalearn.weekop.model.User;
import pl.javalearn.weekop.service.DiscoveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscoveryController", urlPatterns = "/add")
public class DiscoveryController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("inputName");
        String description = request.getParameter("inputDescription");
        String url = request.getParameter("inputUrl");
        User authenticatedUser = (User) request.getSession().getAttribute("user");

        if (request.getUserPrincipal() != null) {
            if (name != null && !"".equals(name) && description != null && !"".equals(description)
                && url != null && !"".equals(url)) {
                DiscoveryService discoveryService = new DiscoveryService();
                discoveryService.addDiscovery(name, description, url, authenticatedUser);
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            response.sendError(403);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal() != null) {
            request.getRequestDispatcher("/WEB-INF/new.jsp").forward(request, response);
        } else {
            response.sendError(403);
        }
    }

}