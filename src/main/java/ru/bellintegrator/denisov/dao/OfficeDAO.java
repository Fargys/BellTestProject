package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.view.OfficeFilterView;

public interface OfficeDAO {
    
    public List<Office> all();

    public List<Office> all(OfficeFilterView filterView);

    public Office loadById(Long id);

    public void update(Office office);

    public void delete(Long id);

    public void save(Office office);
    
}
