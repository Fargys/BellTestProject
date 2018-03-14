package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.OrganizationController;
import ru.bellintegrator.denisov.service.OrganizationService;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;
import ru.bellintegrator.denisov.view.ResponseView;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {
    
    private final OrganizationService organizationService;
    private final ResponseView responseView = new ResponseView();

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public Object organizations(@RequestBody OrganizationFilterView view) {
        return organizationService.organizations(view);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public Object organization(@PathVariable("id") String id) {
        return organizationService.organization(id);
    }

    @Override
    @RequestMapping(value = "/update", method = {PUT})
    public Object update(@RequestBody OrganizationView view) {
        try{
            organizationService.update(view);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public Object save(@RequestBody OrganizationView view) {
        try{
            organizationService.save(view);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = {DELETE})
    public Object delete(@PathVariable("id") String id) {
        try{
            organizationService.delete(id);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }
    
}
