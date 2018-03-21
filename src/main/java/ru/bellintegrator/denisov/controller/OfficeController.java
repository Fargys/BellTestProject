package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;
import ru.bellintegrator.denisov.view.ResponseView;

public interface OfficeController {
    
    public ResponseView offices(OfficeFilterView view);
    
    public ResponseView office(String officeId);
    
    public ResponseView update(OfficeView view);
    
    public ResponseView save(OfficeView view);
    
    public ResponseView delete(String officeId);
    
}