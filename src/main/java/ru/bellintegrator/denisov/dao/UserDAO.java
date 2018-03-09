package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.User;

public interface UserDAO {
    public List<User> users();

    public User loadById();

    public String update();

    public String delete();

    public void save();
}
