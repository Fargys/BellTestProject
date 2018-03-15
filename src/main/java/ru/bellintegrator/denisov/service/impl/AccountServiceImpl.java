package ru.bellintegrator.denisov.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.dao.UserDAO;
import ru.bellintegrator.denisov.model.Account;
import ru.bellintegrator.denisov.view.AccountView;
import ru.bellintegrator.denisov.service.AccountService;
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.service.ActivationService;
import ru.bellintegrator.denisov.service.GeneratorService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class AccountServiceImpl implements AccountService {
    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    
    private final AccountDAO accountDao;
    private final UserDAO userDao;
    private final ActivationService activationService;
    private final GeneratorService generator;
    

    @Autowired
    public AccountServiceImpl(AccountDAO accountDao, UserDAO userDao
            , ActivationService activationService, GeneratorService generator) {
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.activationService = activationService;
        this.generator = generator;
    }

    @Override
    public void register(AccountView view) {
//        1. При регистрации создать неактивного пользователя
//        2. Сгенерировать случайную строку. Хэш от неё записать в бд    
//        3. Сам email отправлять не надо. Добавить запись в БД. 
//            Предполагаем, что их обрабатывает отдельный сервис отправки email. Его делать не надо
    }
    

    @Override
    public void login(AccountView view) throws Throwable {
        Account login = accountDao.loadByLogin(view.login);
        
        String enteringPasswordHash = generator.encode(view.password);
        String truePasswordHash = login.getPassword();
        
        if(enteringPasswordHash != truePasswordHash) throw new Throwable("Wrong password");
    }
    
}
