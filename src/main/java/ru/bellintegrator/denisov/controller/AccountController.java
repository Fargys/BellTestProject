package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.AccountView;
import ru.bellintegrator.denisov.view.ResponseView;

public interface AccountController {
    
    public ResponseView register(AccountView view);
    
    public ResponseView activation(String code);
    
    public ResponseView login(AccountView view);
}
