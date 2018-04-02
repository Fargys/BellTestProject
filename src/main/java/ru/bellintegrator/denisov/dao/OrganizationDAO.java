package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationFilterView;

public interface OrganizationDAO {
    
    public List<Organization> getAllOrganizations();

    public List<Organization> getAllOrganizationsByCriteria(OrganizationFilterView filter);

    public Organization getOrganizationById(Long id);
    
    public Organization getOrganizationByName(String name);

    public void updateOrganization(Organization organization);

    public void saveOrganization(Organization organization);

    public void deleteOrganization(Long id);
    
}
