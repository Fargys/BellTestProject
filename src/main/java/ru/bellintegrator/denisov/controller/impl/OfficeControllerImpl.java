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
    private final ResponseView responseView = new ResponseView();

    @Autowired
    public OfficeControllerImpl(OfficeService officeSerivce) {
        this.officeService = officeSerivce;
    }
    

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public Object offices(@RequestBody OfficeFilterView view) {
        return officeService.offices(view);
    }

    @Override
    @RequestMapping(value = "/{id:.+}", method = {GET})
    public Object office(@PathVariable("id") String id) {
        return officeService.office(id);
    }

    @Override
    @RequestMapping(value = "/update", method = {PUT})
    public Object update(@RequestBody OfficeView view) {
        try{
            officeService.update(view);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = {DELETE})
    public Object delete(@PathVariable("id") String id) {
        try{
            officeService.delete(id);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public Object save(@RequestBody OfficeView view) {
        try{
            officeService.save(view);
            return responseView.getResultView(true);
        }catch(Throwable e) {
            return responseView.getErrorView(e.getMessage());
        }
    }
    
}
