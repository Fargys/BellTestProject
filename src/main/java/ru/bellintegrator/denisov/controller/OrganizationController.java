package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;

public interface OrganizationController {
    
    public Object organizations(OrganizationFilterView view);
    
    public Object organization(String id);
    
    public Object update(OrganizationView view);
    
    public Object save(OrganizationView view);
    
    public Object delete(String id);
    
}