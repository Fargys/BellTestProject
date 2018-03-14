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
import ru.bellintegrator.denisov.dao.LoginDAO;
import ru.bellintegrator.denisov.model.Login;
import ru.bellintegrator.denisov.service.LoginService;
import ru.bellintegrator.denisov.view.LoginView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class LoginServiceImpl implements LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    
    private final LoginDAO dao;
    
    //for encode
    private MessageDigest encoder;
    private byte[] digest = null;
    

    @Autowired
    public LoginServiceImpl(LoginDAO dao) {
        this.dao = dao;
    }

    @Override
    public void register(LoginView view) {
       try {
            encoder = MessageDigest.getInstance("SHA-256");
            digest = encoder.digest(view.password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Login login = new Login();
        
        login.setLogin(view.login);
        login.setPassword(new String(Base64.getEncoder().encode(digest)));
        
        dao.register(login);
    }

    @Override
    public void activation(String code) {
        // send activation code to user email
    }

    @Override
    public void login(LoginView view) throws Throwable {
        try {
            encoder = MessageDigest.getInstance("SHA-256");
            digest = encoder.digest(view.password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Login login = dao.loadByLogin(view.login);
        
        if(digest.toString() != login.getPassword()) throw new Throwable("Wrong password");
    }
    
}
