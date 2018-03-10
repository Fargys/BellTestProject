package ru.bellintegrator.denisov.dao;

import ru.bellintegrator.denisov.model.Login;

public interface LoginDAO {

    public String register(Login login);

    public void activation();

    public String login();
    
}
