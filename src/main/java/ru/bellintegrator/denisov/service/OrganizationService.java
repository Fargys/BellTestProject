package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationView;

public interface OrganizationService {
    
    public List<OrganizationView> organizations();

    public Organization organization(Long id);

    public void update(OrganizationView view);

    public void save(OrganizationView view);

    public void delete(Long id);
}
