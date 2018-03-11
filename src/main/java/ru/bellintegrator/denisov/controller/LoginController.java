package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.LoginView;
import ru.bellintegrator.denisov.view.RegisterView;

public interface LoginController {
    
    String register(RegisterView view);
    
    void activation(String code);
    
    String login(LoginView view);
}
