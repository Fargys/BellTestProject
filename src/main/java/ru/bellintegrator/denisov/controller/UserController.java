package ru.bellintegrator.denisov.controller;

import java.util.List;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserController {
    
    List<User> users(UserFilterView view);
    
    User user(String userId);
    
    String update(UserView view);
    
    void save(UserView view);
    
    String delete(String userId);
}
