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

public class LoginServlet extends HttpServlet {

//    @Autowired
    private static UserService userService = new UserServiceImpl();

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.auth(login, password);
        if (user!= null) {
            if("admin".equals(user.getLogin())){
                req.getSession().setAttribute("adminLogin", login);
                resp.sendRedirect(req.getContextPath() + "/adminmain");
            } else {
                req.getSession().setAttribute("nameUser", user.getName() + " " + user.getSurname());
                req.getSession().setAttribute("userLogin", login);
                resp.sendRedirect(req.getContextPath() + "/main");
            }

        } else {
            resp.sendRedirect(req.getContextPath() + "/loginerror");
        }
    }
}
