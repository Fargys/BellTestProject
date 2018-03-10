package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.view.OfficeView;

public interface OfficeService {
    public List<OfficeView> offices();

    public Office office(Long id);

    public void update(OfficeView view);

    public void delete(Long id);

    public void save(OfficeView view);
    
}
