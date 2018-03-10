package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserView;

public interface UserService {

    public List<UserView> users();

    public User user(Long id);

    public void update(UserView view);

    public void delete(Long id);

    public void save(UserView view);
    
}
