package ru.bellintegrator.denisov.controller;

import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;
import ru.bellintegrator.denisov.view.ResponseView;

public interface OrganizationController {
    
    public ResponseView getAllOrganizationsByCriteria(OrganizationFilterView view);
    
    public ResponseView getOrganizationById(String id);
    
    public ResponseView updateOrganization(OrganizationView view);
    
    public ResponseView saveOrganization(OrganizationView view);
    
    public ResponseView deleteOrganization(String id);
    
}