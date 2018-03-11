package ru.bellintegrator.denisov.controller;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationFiltertView;
import ru.bellintegrator.denisov.view.OrganizationSaveView;
import ru.bellintegrator.denisov.view.OrganizationUpdateView;

public interface OrganizationController {
    
    List<Organization> organizations(OrganizationFiltertView view);
    
    Organization organization(String id);
    
    String update(OrganizationUpdateView view);
    
    String save(OrganizationSaveView view);
    
    String delete(String id);
    
}