package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationFilterView;

public interface OrganizationDAO {

    public List<Organization> all(OrganizationFilterView filter);

    public Organization loadById(Long id);
    
    public Organization loadByName(String name);

    public void update(Organization organization);

    public void save(Organization organization);

    public void delete(Long id);
    
}
