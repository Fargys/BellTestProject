package ru.bellintegrator.denisov.controller;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;

public interface OrganizationController {
    
    public List<OrganizationView> organizations(OrganizationFilterView view);
    
    public Organization organization(String id);
    
    public String update(OrganizationView view);
    
    public String save(OrganizationView view);
    
    public String delete(String id);
    
}