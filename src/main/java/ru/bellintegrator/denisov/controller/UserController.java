package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserController {
    
    public Object users(UserFilterView view);
    
    public Object user(String userId);
    
    public Object update(UserView view);
    
    public Object save(UserView view);
    
    public Object delete(String userId);
}
