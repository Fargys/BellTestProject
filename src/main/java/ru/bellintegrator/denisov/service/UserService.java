package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserService {

    public List<UserView> users(UserFilterView view);

    public User user(String id);

    public void update(UserView view);

    public void delete(String id);

    public void save(UserView view);
    
}
