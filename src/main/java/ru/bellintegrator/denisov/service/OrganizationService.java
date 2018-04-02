package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;

public interface OrganizationService {
    
    public List<OrganizationView> getAllOrganizationByCriteria(OrganizationFilterView view);

    public OrganizationView getOrganizationById(String id);

    public void updateOrganization(OrganizationView view);

    public void saveOrganization(OrganizationView view);

    public void deleteOrganization(String id);
}
