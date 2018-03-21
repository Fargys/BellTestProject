package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;
import ru.bellintegrator.denisov.view.ResponseView;

public interface OrganizationController {
    
    public ResponseView organizations(OrganizationFilterView view);
    
    public ResponseView organization(String id);
    
    public ResponseView update(OrganizationView view);
    
    public ResponseView save(OrganizationView view);
    
    public ResponseView delete(String id);
    
}