package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;

public interface OfficeDAO {

    public List<Office> all();

    public Office loadById(Long id);

    public void update(Office office);

    public void delete(Long id);

    public void save(Office office);
    
}
