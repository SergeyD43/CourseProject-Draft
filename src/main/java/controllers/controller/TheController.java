package main.java.controllers.controller;


import main.java.controllers.exceptions.CustomGenericException;
import main.java.controllers.util.Validator;
import main.java.services.UserService;
import main.java.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TheController {

    private final UserService userService;

    @Autowired
    public TheController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showRegistration() {
        return new ModelAndView("/registration");
    }

    @RequestMapping(value = {"/" ,"/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Логин или пароль некорректен");
        }

        if (logout != null) {
            model.addAttribute("message", "Выход совершён успешно");
        }

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView makeRegistration(@RequestParam("login") String login, @RequestParam("password") String password,
                                         @RequestParam("name") String name, @RequestParam("surname") String surname){
        ModelAndView modelAndView;
        boolean exception=false;

        Validator.proverka(login, password, name, surname);

        try {
            userService.signUp(login, password, name, surname);
        } catch (Exception e) {
            exception = true;
        }

        if(exception){
            throw new CustomGenericException("данный логин уже существет!", "");
        } else {
            UserDTO userDTO = userService.getUserByLogin(login);
            String userLogin = userDTO.getLogin();
            modelAndView = new ModelAndView("redirect:/main/" + userLogin);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/adminmain")
    public ModelAndView showAdminPanel(){
        ModelAndView modelAndView = new ModelAndView("/adminmain");
        List<UserDTO> userDTOs = userService.getAllUsers();

        modelAndView.addObject("users2", userDTOs);
        return modelAndView;
    }

    @RequestMapping(value = "/main/{login}")
    public ModelAndView showMainPanel(@PathVariable String login){
        ModelAndView modelAndView = new ModelAndView("/main");
        UserDTO userDTO = userService.getUserByLogin(login);
        modelAndView.addObject("nameUser", userDTO.getName() + " " + userDTO.getSurname());
        modelAndView.addObject("room", userDTO.getIdRoom());
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView makeExit(){
        return new ModelAndView("redirect:/login");
    }

    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {
        ModelAndView model = new ModelAndView("registration");
        model.addObject("errCode", ex.getErrCode());
        model.addObject("errMsg", ex.getErrMsg());
        return model;
    }
}
