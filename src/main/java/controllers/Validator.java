package main.java.controllers;

public class Validator {
    public static void proverka(String login, String password, String name, String surname) {
        if(login.length()<6){
            throw new CustomGenericException("длина логина должна быть не менее 6 символов", "");
        }

        if(password.length()<8){
            throw new CustomGenericException("длина пароля должна быть не менее 8 символов", "");
        }

        if(!password.matches("[A-z0-9]+")){
            throw new CustomGenericException("пароль не соответствует требованиям", "");
        }
    }
}
