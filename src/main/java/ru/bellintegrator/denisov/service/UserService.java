package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

public interface UserService {

    public List<UserView> getAllUsersByCriteria(UserFilterView view);

    public UserView getUserById(String id);

    public void updateUser(UserView view);

    public void deleteUser(String id);

    public void saveUser(UserView view);
    
}
