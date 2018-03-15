package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.view.AccountView;
import ru.bellintegrator.denisov.view.ResponseView;
import ru.bellintegrator.denisov.service.AccountService;
import ru.bellintegrator.denisov.controller.AccountController;
import ru.bellintegrator.denisov.service.ActivationService;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class AccountControllerImpl implements AccountController {
    
    private final AccountService loginService;
    private final ActivationService activationService;
    private final ResponseView responseView = new ResponseView();

    @Autowired
    public AccountControllerImpl(AccountService loginService, ActivationService activationService) {
        this.loginService = loginService;
        this.activationService = activationService;
    }

    @Override
    @RequestMapping(value = "/register", method = {POST})
    public Object register(@RequestBody AccountView view) {
        try{
            loginService.register(view);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/activation", method = {GET})
    public void activation(@RequestParam("code") String code) {
        activationService.activation(code);
    }

    @Override
    @RequestMapping(value = "/login", method = {POST})
    public Object login(@RequestBody AccountView view) {
        try{
            loginService.login(view);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }
}
