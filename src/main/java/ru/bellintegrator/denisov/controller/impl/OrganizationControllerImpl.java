package ru.bellintegrator.denisov.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.OrganizationController;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.service.OrganizationService;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;
import ru.bellintegrator.denisov.view.ResponseView;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {
    
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationView> organizations(@RequestBody OrganizationFilterView view) {
        return organizationService.organizations(view);
    }

    @Override
    @RequestMapping(value = "/{id:.+}", method = {GET})
    public Organization organization(@PathVariable("id") String id) {
        return organizationService.organization(id);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public String update(@RequestBody OrganizationView view) {
        try{
            organizationService.update(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public String save(@RequestBody OrganizationView view) {
        try{
            organizationService.save(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public String delete(@PathVariable("id") String id) {
        try{
            organizationService.delete(id);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }
    
}
