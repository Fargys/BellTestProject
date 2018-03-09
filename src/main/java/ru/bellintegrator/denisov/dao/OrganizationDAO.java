package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;

public interface OrganizationDAO {

    public List<Organization> all();

    public Organization loadById();

    public void update();

    public void save();

    public void delete();
    
}
