package ru.bellintegrator.denisov.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.OrganizationController;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.service.OrganizationService;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {
    
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    @RequestMapping(value = "/api/organization/list", method = {POST})
    public List<Organization> organizations(String name, String inn, Boolean isActive) {
        return organizationService.organizations();
    }

    @Override
    @RequestMapping(value = "/api/organization/{id:.+}", method = {GET})
    public Organization organization(Long id) {
        return organizationService.organization();
    }

    @Override
    @RequestMapping(value = "/api/organization/update", method = {POST})
    public String update(Long id, String nmae, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        return organizationService.update();
    }

    @Override
    @RequestMapping(value = "/api/organization/save", method = {POST})
    public String save(String nmae, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        return organizationService.save();
    }

    @Override
    @RequestMapping(value = "/api/organization/delete", method = {POST})
    public String delete(Long id) {
        return organizationService.delete();
    }
    
    
}
