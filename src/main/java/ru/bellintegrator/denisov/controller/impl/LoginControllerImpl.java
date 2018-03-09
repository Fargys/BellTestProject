package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.LoginController;
import ru.bellintegrator.denisov.service.LoginService;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class LoginControllerImpl implements LoginController {
    
    private final LoginService loginService;

    @Autowired
    public LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    @RequestMapping(value = "/api/register", method = {POST})
    public String register(String login, String password, String name) {
        return loginService.register();
    }

    @Override
    @RequestMapping(value = "/activation?code", method = {GET})
    public void activation(String code) {
        loginService.activation();
    }

    @Override
    @RequestMapping(value = "/api/login", method = {POST})
    public String login(String login, String password) {
        return loginService.login();
    }
}
