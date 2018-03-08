package ru.bellintegrator.practice.denisov.controller;

import java.util.List;
import ru.bellintegrator.practice.denisov.model.User;

public interface UserController {
    
    List<User> users(String filter);
    
    User user(Long userId);
    
    String update(Long userId, String firstName, String secondName, String middleName, String position, 
            String phone, Long documentId, Long citizenshipId, Boolean isIdentified);
    
    String delete(Long userId);
    
    void save(String firstName, String secondName, String middleName, String position, 
            String phone, Long documentId, Long citizenshipId, Boolean isIdentified);
}
