package ru.bellintegrator.denisov.dao;

import ru.bellintegrator.denisov.model.Account;

public interface AccountDAO {

    public String register(Account account);

    public Account loadByLogin(String login);

    public Account getByActivationCode(String hashForActivationCode);
    
}
