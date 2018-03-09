package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.Organization;

public interface OrganizationService {
    
    public List<Organization> organizations();

    public Organization organization();

    public String update();

    public String save();

    public String delete();
}
