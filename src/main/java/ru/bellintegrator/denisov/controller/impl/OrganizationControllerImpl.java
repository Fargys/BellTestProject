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
import ru.bellintegrator.denisov.exception.OrganizationControllerException;
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
    public ResponseView getAllOrganizationsByCriteria(@RequestBody OrganizationFilterView view) {
        try {
            if(view.name == null) throw new OrganizationControllerException();
            Object data = organizationService.getAllOrganizationByCriteria(view);
        
        return ResponseView.newBuilder()
                .setData(data)
                .build();
        
        } catch (Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getOrganizationById(@PathVariable("id") String id) {
        try {
            if(id == null) throw new OrganizationControllerException();
            Object data = organizationService.getOrganizationById(id);
        
            return ResponseView.newBuilder()
                    .setData(data)
                    .build();
        
        } catch (Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/update", method = {PUT})
    public ResponseView updateOrganization(@RequestBody OrganizationView view) {
        try{
            if(view.id == null) throw new OrganizationControllerException();
            organizationService.updateOrganization(view);
            return ResponseView.newBuilder()
                    .setResult(true)
                    .build();
        }catch(Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView saveOrganization(@RequestBody OrganizationView view) {
        try{
            organizationService.saveOrganization(view);
            return ResponseView.newBuilder()
                    .setResult(true)
                    .build();
        }catch(Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = {DELETE})
    public ResponseView deleteOrganization(@PathVariable("id") String id) {
        try{
            if(id == null) throw new OrganizationControllerException();
            organizationService.deleteOrganization(id);
            return ResponseView.newBuilder()
                    .setResult(true)
                    .build();
        }catch(Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
    
}
