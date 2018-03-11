package ru.bellintegrator.denisov.controller;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeUpdateView;
import ru.bellintegrator.denisov.view.OfficeSaveView;

public interface OfficeController {
    
    List<Office> offices(OfficeFilterView view);
    
    Office office(String officeId);
    
    String update(OfficeUpdateView view);
    
    String save(OfficeSaveView view);
    
    String delete(String officeId);
    
}