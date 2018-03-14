package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.LoginView;

public interface LoginController {
    
    public Object register(LoginView view);
    
    public void activation(String code);
    
    public Object login(LoginView view);
}
