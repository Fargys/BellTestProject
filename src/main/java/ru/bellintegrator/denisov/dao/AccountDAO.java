package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Account;

public interface AccountDAO {
    
    public List<Account> getAllAccounts();

    public void register(Account account);

    public Account loadByLogin(String login);

    public Account loadByActivationCode(String hashForActivationCode);
    
}
