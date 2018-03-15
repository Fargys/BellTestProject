package ru.bellintegrator.denisov.dao;

import ru.bellintegrator.denisov.model.Account;

public interface AccountDAO {

    public void register(Account account);

    public Account loadByLogin(String login);

    public Account loadByActivationCode(String hashForActivationCode);
    
}
