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
    
    private final AccountService accountService;
    private final ActivationService activationService;

    @Autowired
    public AccountControllerImpl(AccountService accountService, ActivationService activationService) {
        this.accountService = accountService;
        this.activationService = activationService;
    }

    @Override
    @RequestMapping(value = "/register", method = {POST})
    public ResponseView register(@RequestBody AccountView view) {
        try{
            accountService.register(view);
            return ResponseView.newBuilder()
                    .setResult(true)
                    .build();
        }catch(Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/activation", method = {GET})
    public ResponseView activation(@RequestParam("code") String code) {
        try{
            activationService.activation(code);
            return ResponseView.newBuilder()
                    .setResult(true)
                    .build();
        }catch(Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/login", method = {POST})
    public ResponseView login(@RequestBody AccountView view) {
        try{
            accountService.login(view);
            return ResponseView.newBuilder()
                    .setResult(true)
                    .build();
        }catch(Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
}
