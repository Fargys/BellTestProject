package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginView {
    
    public String login;
    
    public String password;
    
    public String name;
    
    // for jackson
    public LoginView() {

    }
    
}
