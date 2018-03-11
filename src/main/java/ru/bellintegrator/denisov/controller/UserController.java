package ru.bellintegrator.denisov.controller;

import java.util.List;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserController {
    
    public List<UserView> users(UserFilterView view);
    
    public User user(String userId);
    
    public String update(UserView view);
    
    public String save(UserView view);
    
    public String delete(String userId);
}
