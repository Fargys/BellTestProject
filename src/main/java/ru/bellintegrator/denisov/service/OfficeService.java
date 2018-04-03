package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

public interface OfficeService {
    
    public List<OfficeView> getAllOfficesByCriteria(OfficeFilterView view);

    public OfficeView getOfficeById(String id);

    public void updateOffice(OfficeView view);

    public void deleteOffice(String id);

    public void saveOffice(OfficeView view);
    
}
