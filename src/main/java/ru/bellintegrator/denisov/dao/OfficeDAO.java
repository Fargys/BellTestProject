package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;

public interface OfficeDAO {

    public List<Office> all();

    public Office loadById();

    public String update();

    public String delete();

    public String save();
    
}
