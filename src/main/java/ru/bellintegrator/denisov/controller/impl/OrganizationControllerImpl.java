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
    public ResponseView organizations(@RequestBody OrganizationFilterView view) {
        try {
            if(view.name == null) throw new OrganizationControllerException();
            Object data = organizationService.organizations(view);
        
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
    public ResponseView organization(@PathVariable("id") String id) {
        try {
            Object data = organizationService.organization(id);
        
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
    public ResponseView update(@RequestBody OrganizationView view) {
        try{
            organizationService.update(view);
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
    public ResponseView save(@RequestBody OrganizationView view) {
        try{
            organizationService.save(view);
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
    public ResponseView delete(@PathVariable("id") String id) {
        try{
            organizationService.delete(id);
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
