package ru.bellintegrator.denisov.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.dao.UserDAO;
import ru.bellintegrator.denisov.model.Account;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.AccountView;
import ru.bellintegrator.denisov.service.AccountService;
import ru.bellintegrator.denisov.dao.AccountDAO;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class AccountServiceImpl implements AccountService {
    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    
    private final AccountDAO dao;
    private final UserDAO userDao;
    
    //for encode
    private MessageDigest encoder;
    private byte[] digest = null;
    

    @Autowired
    public AccountServiceImpl(AccountDAO dao, UserDAO userDao) {
        this.dao = dao;
        this.userDao = userDao;
    }

    @Override
    public void register(AccountView view) {
//        1. При регистрации создать неактивного пользователя
       User noActiveUser = new User();
       noActiveUser.setIdentified(false);
//        2. Сгенерировать случайную строку. Хэш от неё записать в бд       
       String newPassword = null;
       view.password = newPassword;
//        3. Сам email отправлять не надо. Добавить запись в БД. 
//            Предполагаем, что их обрабатывает отдельный сервис отправки email. Его делать не надо
       Account login = new Account();
       login.setLogin(view.login);
       login.setPassword(newPassword);
       
       
    }
    

    @Override
    public void login(AccountView view) throws Throwable {
        try {
            encoder = MessageDigest.getInstance("SHA-256");
            digest = encoder.digest(view.password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Account login = dao.loadByLogin(view.login);
        
        if(digest.toString() != login.getPassword()) throw new Throwable("Wrong password");
    }
    
}
