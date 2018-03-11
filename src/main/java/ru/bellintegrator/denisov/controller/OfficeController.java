package ru.bellintegrator.denisov.controller;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

public interface OfficeController {
    
    public List<OfficeView> offices(OfficeFilterView view);
    
    public Office office(String officeId);
    
    public String update(OfficeView view);
    
    public String save(OfficeView view);
    
    public String delete(String officeId);
    
}