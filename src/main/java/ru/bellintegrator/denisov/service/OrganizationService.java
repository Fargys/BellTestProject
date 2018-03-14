package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;

public interface OrganizationService {
    
    public List<OrganizationView> organizations(OrganizationFilterView view);

    public OrganizationView organization(String id);

    public void update(OrganizationView view);

    public void save(OrganizationView view);

    public void delete(String id);
}
