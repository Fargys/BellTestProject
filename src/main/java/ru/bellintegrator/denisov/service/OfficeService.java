package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

public interface OfficeService {
    
    public List<OfficeView> offices(OfficeFilterView view);

    public OfficeView office(String id);

    public void update(OfficeView view);

    public void delete(String id);

    public void save(OfficeView view);
    
}
