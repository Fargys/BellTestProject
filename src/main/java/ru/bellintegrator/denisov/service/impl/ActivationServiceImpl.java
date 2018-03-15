package ru.bellintegrator.denisov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.model.Account;
import ru.bellintegrator.denisov.service.ActivationService;
import ru.bellintegrator.denisov.service.GeneratorService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ActivationServiceImpl implements ActivationService {
    
    private final AccountDAO dao;
    private final GeneratorService generator;

    @Autowired
    public ActivationServiceImpl(AccountDAO dao, GeneratorService generator) {
        this.dao = dao;
        this.generator = generator;
    }
    
    @Override
    public void activation(String activationCode) {
        String hashForActivationCode = generator.encode(activationCode);
        Account account = dao.getByActivationCode(hashForActivationCode);
        
        if(account != null) account.getUser().setIdentified(true);
    }
    
}
