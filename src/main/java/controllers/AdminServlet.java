package controllers;

import model.pojo.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
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
