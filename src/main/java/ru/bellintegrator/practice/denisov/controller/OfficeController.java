package ru.bellintegrator.practice.denisov.controller;

import java.util.List;
import ru.bellintegrator.practice.denisov.model.Office;

public interface OfficeController {
    
    List<Office> offices(Long orgId, String name, String phone, Boolean isActive);
    
    Office office(Long officeId);
    
    String update(Long officeId, String name, String address, String phone, Boolean isActive);
    
    String delete(Long officeId);
    
    String save(String name, String address, String phone, Boolean isActive);
    
}