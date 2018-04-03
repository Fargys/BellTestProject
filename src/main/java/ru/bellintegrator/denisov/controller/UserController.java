package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.ResponseView;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserController {
    
    public ResponseView getAllUsersByCriteria(UserFilterView view);
    
    public ResponseView getUserById(String userId);
    
    public ResponseView updateUser(UserView view);
    
    public ResponseView saveUser(UserView view);
    
    public ResponseView deleteUser(String userId);
}
