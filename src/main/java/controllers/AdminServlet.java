package main.java.controllers;

import main.java.model.pojo.User;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, admin");

        List<User> users = userService.getAllUsers();

        for (User item:users) {
            System.out.println(item);
        }

        req.setAttribute("users2", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminmain.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("exit")!=null){
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
