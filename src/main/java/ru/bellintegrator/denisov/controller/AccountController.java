package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.AccountView;

public interface AccountController {
    
    public Object register(AccountView view);
    
    public void activation(String code);
    
    public Object login(AccountView view);
}
