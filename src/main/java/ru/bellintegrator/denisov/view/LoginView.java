package ru.bellintegrator.denisov.view;

import io.swagger.annotations.ApiModelProperty;

public class LoginView {
    @ApiModelProperty(hidden = true)
    public String id;
    
    public String login;
    
    public String password;
    
    //for jackson
    public LoginView() {

    }

    @Override
    public String toString() {
        return "LoginView{" + "id=" + id + ", login=" + login + ", password=" + password + '}';
    }
    
    
}
