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

public class RegistrationServlet extends HttpServlet {

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher( "/registration.jsp" );
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        boolean exception=false;

        try {
            userService.signUp(login, password, name, surname);
        } catch (Exception e) {
            exception = true;
        }

        if(exception){
            resp.sendRedirect(req.getContextPath() + "/loginerror");
        } else {
            User user = userService.auth(login, password);
            req.getSession().setAttribute("nameUser", user.getName() + " " + user.getSurname());
            req.getSession().setAttribute("userLogin", login);
            resp.sendRedirect(req.getContextPath() + "/main");
        }

    }
}
