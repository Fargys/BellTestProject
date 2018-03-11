package ru.bellintegrator.denisov.service;

import ru.bellintegrator.denisov.view.LoginView;

public interface LoginService {

    public void register(LoginView view);

    public void activation(String code);

    public String login(LoginView view);
    
}
