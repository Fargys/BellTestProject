package ru.bellintegrator.denisov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.service.ReferenceService;
import ru.bellintegrator.denisov.view.ResponseView;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class ReferenceController {
    
    private final ReferenceService referenceService;

    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }
    
    @RequestMapping(value = "/api/docs", method = {GET})
    public ResponseView documents() {
        try {
           Object data = referenceService.documentTypes();
        
            return ResponseView.newBuilder()
                    .setData(data)
                    .build();
        
        } catch (Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
    
    @RequestMapping(value = "/api/countries", method = {GET})
    public ResponseView countries() {
        try {
           Object data = referenceService.citizenshipTypes();
        
            return ResponseView.newBuilder()
                    .setData(data)
                    .build();
        
        } catch (Throwable e) {
            return ResponseView.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
}
