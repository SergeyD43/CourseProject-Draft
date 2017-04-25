package controllers;

import model.pojo.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, admin");

        List<User> users = userService.getAllUsers();

        req.setAttribute("users", users);


        getServletContext().getRequestDispatcher("/adminmain.jsp")
                .forward(req, resp);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminmain.jsp");
//        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

    }
}
