package main.java.controllers;


import main.java.model.pojo.User;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public ModelAndView main() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showRegistration() {
        return new ModelAndView("registration");
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView showMain(@RequestParam("login") String login, @RequestParam("password") String password){
        ModelAndView modelAndView;
        User user = userService.auth(login, password);
        if (user!= null) {
            if("admin".equals(user.getLogin())){
                modelAndView = new ModelAndView("redirect:/adminmain");
            } else {
                modelAndView = new ModelAndView();
                int idUser = user.getIdUser();
                modelAndView.setViewName("redirect:/main/" + idUser);
            }
        } else {
            modelAndView = new ModelAndView("redirect:/loginerror");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView makeRegistration(@RequestParam("login") String login, @RequestParam("password") String password,
                                         @RequestParam("name") String name, @RequestParam("surname") String surname){
        ModelAndView modelAndView;
        boolean exception=false;

        try {
            userService.signUp(login, password, name, surname);
        } catch (Exception e) {
            exception = true;
        }

        if(exception){
            modelAndView = new ModelAndView("redirect:/loginerror");
        } else {
            User user = userService.getUserByLogin(login);
            int idUser = user.getIdUser();
            modelAndView = new ModelAndView("redirect:/main/" + idUser);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/adminmain")
    public ModelAndView showAdminPanel(){
        ModelAndView modelAndView = new ModelAndView("adminmain");
        List<User> users = userService.getAllUsers();

        modelAndView.addObject("users2", users);
        return modelAndView;
    }

    @RequestMapping(value = "/main/{id}")
    public ModelAndView showMainPanel(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("main");
        User user = userService.getUserById(id);
        modelAndView.addObject("nameUser", user.getName() + " " + user.getSurname());
        modelAndView.addObject("room", user.getIdRoom());
        return modelAndView;
    }


    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView makeExit(){
        return new ModelAndView("redirect:/login");
    }
}
