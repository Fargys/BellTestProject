package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;

public interface OrganizationDAO {

    public List<Organization> all();

    public Organization loadById(Long id);

    public void update(Organization organization);

    public Long save(Organization organization);

    public void delete(Long id);
    
}
