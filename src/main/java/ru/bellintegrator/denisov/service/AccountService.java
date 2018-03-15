package ru.bellintegrator.denisov.service;

import ru.bellintegrator.denisov.view.AccountView;

public interface AccountService {

    public void register(AccountView view);

    public void login(AccountView view) throws Throwable;
    
}
