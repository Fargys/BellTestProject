package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.ResponseView;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserController {
    
    public ResponseView users(UserFilterView view);
    
    public ResponseView user(String userId);
    
    public ResponseView update(UserView view);
    
    public ResponseView save(UserView view);
    
    public ResponseView delete(String userId);
}
