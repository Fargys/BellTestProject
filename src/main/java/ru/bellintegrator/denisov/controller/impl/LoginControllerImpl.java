package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.LoginController;
import ru.bellintegrator.denisov.service.LoginService;
import ru.bellintegrator.denisov.view.LoginView;
import ru.bellintegrator.denisov.view.ResponseView;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class LoginControllerImpl implements LoginController {
    
    private final LoginService loginService;

    @Autowired
    public LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    @RequestMapping(value = "/register", method = {POST})
    public String register(@RequestBody LoginView view) {
        try{
            loginService.register(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/activation", method = {GET})
    public void activation(@PathVariable("code") String code) {
        loginService.activation(code);
    }

    @Override
    @RequestMapping(value = "/login", method = {POST})
    public String login(@RequestBody LoginView view) {
        try{
            loginService.login(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }
}
