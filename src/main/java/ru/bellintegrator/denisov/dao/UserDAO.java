package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;

public interface UserDAO {
    
    public List<User> all();
   
    public List<User> all(UserFilterView filterView);

    public User loadById(Long id);

    public void update(User user);

    public void delete(Long id);

    public void save(User user);
}
