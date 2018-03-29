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
import ru.bellintegrator.denisov.controller.OfficeController;
import ru.bellintegrator.denisov.service.OfficeService;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;
import ru.bellintegrator.denisov.view.ResponseView;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {
    
    private final OfficeService officeService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeSerivce) {
        this.officeService = officeSerivce;
    }
    

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public ResponseView offices(@RequestBody OfficeFilterView view) {
        try {
            Object data = officeService.offices(view);
        
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
    public ResponseView office(@PathVariable("id") String id) {
        try {
            Object data = officeService.office(id);
        
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
    public ResponseView update(@RequestBody OfficeView view) {
        try{
            officeService.update(view);
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
            officeService.delete(id);
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
    public ResponseView save(@RequestBody OfficeView view) {
        try{
            officeService.save(view);
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
