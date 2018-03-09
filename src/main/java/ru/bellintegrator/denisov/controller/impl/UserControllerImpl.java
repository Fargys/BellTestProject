package ru.bellintegrator.denisov.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.UserController;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {
    
    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    @RequestMapping(value = "/api/user/list", method = {POST})
    public List<User> users(String filter) {
        return userService.users();
    }

    @Override
    @RequestMapping(value = "/api/user/{id:.+}", method = {GET})
    public User user(Long userId) {
        return userService.loadById();
    }

    @Override
    @RequestMapping(value = "/api/user/update", method = {POST})
    public String update(Long userId, String firstName, String secondName, String middleName, String position, String phone, Long documentId, Long citizenshipId, Boolean isIdentified) {
        return userService.update();
    }

    @Override
    @RequestMapping(value = "/api/user/delete", method = {POST})
    public String delete(Long userId) {
        return userService.delete();
    }

    @Override
    @RequestMapping(value = "/api/user/save", method = {POST})
    public void save(String firstName, String secondName, String middleName, String position, String phone, Long documentId, Long citizenshipId, Boolean isIdentified) {
        userService.save();
    }
}
