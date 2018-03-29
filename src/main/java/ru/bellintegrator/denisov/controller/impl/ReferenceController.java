package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.service.ReferenceService;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class ReferenceController {
    
    private final ReferenceService referenceService;

    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }
    
    @RequestMapping(value = "/api/docs", method = {GET})
    public Object documents() {
        return referenceService.documentTypes();
    }
    
    @RequestMapping(value = "/api/countries", method = {GET})
    public Object countries() {
        return referenceService.citizenshipTypes();
    }
}
