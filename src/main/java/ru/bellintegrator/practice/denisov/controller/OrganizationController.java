package ru.bellintegrator.practice.denisov.controller;

import java.util.List;
import ru.bellintegrator.practice.denisov.model.Organization;

public interface OrganizationController {
    
    List<Organization> organizations(String name, String inn, Boolean isActive);
    
    Organization organization(Long id);
    
    String update(Long id, String nmae, String fullName, String inn, String kpp, String address, String phone, Boolean isActive);
    
    String save(String nmae, String fullName, String inn, String kpp, String address, String phone, Boolean isActive);
    
    String delete(Long id);
    
}