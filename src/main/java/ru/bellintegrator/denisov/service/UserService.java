package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.User;

public interface UserService {

    public List<User> users();

    public User loadById();

    public String update();

    public String delete();

    public void save();
    
}
