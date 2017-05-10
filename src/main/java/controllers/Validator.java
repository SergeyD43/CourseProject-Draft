package main.java.controllers;

/**
 * Created by Admin on 10.05.2017.
 */
public class Validator {
    public static void proverka(String login, String password, String name, String surname) {
        if(login.length()<6){
//            System.out.println("bom");
            throw new CustomGenericException("длина логина должна быть не менее 6 символов", "");
        }
    }
}
