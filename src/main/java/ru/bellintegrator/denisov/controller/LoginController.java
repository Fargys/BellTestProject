package ru.bellintegrator.denisov.controller;

public interface LoginController {
    
    String register(String login, String password, String name);
    
    void activation(String code);
    
    String login(String login, String password);
}
