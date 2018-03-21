package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.UserController;
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
    public ResponseView users(@RequestBody UserFilterView view) {
        try {
            Object data = userService.users(view);
        
            return ResponseView.newBuilder()
                    .setData(data)
                    .build();
        
        } catch (Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView user(@PathVariable("id") String id) {
        try {
            Object data = userService.user(id);
        
            return ResponseView.newBuilder()
                    .setData(data)
                    .build();
        
        } catch (Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/update", method = {PUT})
    public ResponseView update(@RequestBody UserView view) {
        try{
            userService.update(view);
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
    @RequestMapping(value = "/{id}", method = {DELETE})
    public ResponseView delete(@PathVariable("id") String id) {
        try{
            userService.delete(id);
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
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody UserView view) {
        try{
            userService.save(view);
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
