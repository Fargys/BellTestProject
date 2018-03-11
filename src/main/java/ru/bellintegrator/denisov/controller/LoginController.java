package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.LoginView;

public interface LoginController {
    
    public String register(LoginView view);
    
    public void activation(String code);
    
    public String login(LoginView view);
}
