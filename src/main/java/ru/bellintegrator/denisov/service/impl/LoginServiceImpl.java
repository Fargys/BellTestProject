package ru.bellintegrator.denisov.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.dao.LoginDAO;
import ru.bellintegrator.denisov.model.Login;
import ru.bellintegrator.denisov.service.LoginService;
import ru.bellintegrator.denisov.view.LoginView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class LoginServiceImpl implements LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    
    private final LoginDAO dao;

    @Autowired
    public LoginServiceImpl(LoginDAO dao) {
        this.dao = dao;
    }

    @Override
    public void register(LoginView view) {
        Login login = new Login();
        login.setLogin(view.login);
        login.setPassword(view.password);
        dao.register(login);
        
        
    }

    @Override
    public void activation() {
        
    }

    @Override
    public String login(LoginView view) {
        
    }
    
    
    
    
}
