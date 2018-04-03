package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;

public interface UserDAO {
    
    public List<User> getAllUsers();
   
    public List<User> getAllUsersByCriteria(UserFilterView filterView);

    public User getUserById(Long id);
    
    public User getUserByName(String name);

    public void updateUser(User user);

    public void deleteUser(Long id);

    public void saveUser(User user);
}
