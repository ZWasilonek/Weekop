package pl.javalearn.weekop.controller;

import pl.javalearn.weekop.service.DiscoveryService;
import pl.javalearn.weekop.model.Discovery;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeController", urlPatterns = "")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveDiscoveriesRequest(request);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }

    private void saveDiscoveriesRequest(HttpServletRequest request) {
        DiscoveryService discoveryService = new DiscoveryService();
        List<Discovery> allDiscoveries = discoveryService.getAllDiscoveries(new Comparator<Discovery>() {
            @Override
            public int compare(Discovery d1, Discovery d2) {
                int d1Vote = d1.getUpVote() - d1.getDownVote();
                int d2Vote = d2.getUpVote() - d2.getDownVote();
                if (d1Vote < d2Vote) {
                    return 1;
                } else if (d1Vote > d2Vote) {
                    return -1;
                }
                return 0;
            }
        });
        request.setAttribute("discoveries", allDiscoveries);
    }

}