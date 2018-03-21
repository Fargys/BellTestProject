package ru.bellintegrator.denisov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.model.Account;
import ru.bellintegrator.denisov.view.AccountView;
import ru.bellintegrator.denisov.service.AccountService;
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.exception.ServiceAccountException;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.service.GeneratorService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class AccountServiceImpl implements AccountService {
    
    private final AccountDAO accountDao;
    private final GeneratorService generator;
    

    @Autowired
    public AccountServiceImpl(AccountDAO accountDao, GeneratorService generator) {
        this.accountDao = accountDao;
        this.generator = generator;
    }

    @Override
    public void register(AccountView view) {
        User newNoActiveUser = new User();
        Account newAccount = new Account();
        String password = generator.encode(view.password);
        String activationCode = generator.generateString();
        
        newAccount.setLogin(view.login);
        newAccount.setPassword(password);
        newAccount.setActivationCode(activationCode);
        newAccount.setUser(newNoActiveUser);
        
        accountDao.register(newAccount);
    }
    

    @Override
    public void login(AccountView view) throws Throwable {
        Account login = accountDao.loadByLogin(view.login);
        
        String enteringPasswordHash = generator.encode(view.password);
        String truePasswordHash = login.getPassword();
        
        if(enteringPasswordHash != truePasswordHash) throw new ServiceAccountException();
    }
    
}
