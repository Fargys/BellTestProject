package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationUpdateView;

public interface OrganizationService {
    
    public List<OrganizationUpdateView> organizations();

    public Organization organization(Long id);

    public void update(OrganizationUpdateView view);

    public void save(OrganizationUpdateView view);

    public void delete(Long id);
}
