package ru.bellintegrator.denisov.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.UserController;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.service.UserService;
import ru.bellintegrator.denisov.view.ResponseView;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {
    
    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<UserView> users(@RequestBody UserFilterView view) {
        return userService.users(view);
    }

    @Override
    @RequestMapping(value = "/{id:.+}", method = {GET})
    public User user(@PathVariable("id") String id) {
        return userService.user(id);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public String update(@RequestBody UserView view) {
        try{
            userService.update(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public String delete(@PathVariable("id") String id) {
        try{
            userService.delete(id);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public String save(@RequestBody UserView view) {
        try{
            userService.save(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }
}
