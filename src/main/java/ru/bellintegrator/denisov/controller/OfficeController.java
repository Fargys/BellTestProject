package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

public interface OfficeController {
    
    public Object offices(OfficeFilterView view);
    
    public Object office(String officeId);
    
    public Object update(OfficeView view);
    
    public Object save(OfficeView view);
    
    public Object delete(String officeId);
    
}