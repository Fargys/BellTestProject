package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.view.OfficeFilterView;

public interface OfficeDAO {
    
    public List<Office> getAllOffices();

    public List<Office> getAllOfficesByCriteria(OfficeFilterView filterView);

    public Office getOfficeById(Long id);
    
    public Office getOfficeByName(String name);

    public void updateOffice(Office office);

    public void deleteOffice(Long id);

    public void saveOffice(Office office);
    
}
