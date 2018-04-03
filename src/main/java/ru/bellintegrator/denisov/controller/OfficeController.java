package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;
import ru.bellintegrator.denisov.view.ResponseView;

public interface OfficeController {
    
    public ResponseView getAllOfficesByCriteria(OfficeFilterView view);
    
    public ResponseView getOfficeById(String officeId);
    
    public ResponseView updateOffice(OfficeView view);
    
    public ResponseView saveOffice(OfficeView view);
    
    public ResponseView deleteOffice(String officeId);
    
}