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
import ru.bellintegrator.denisov.controller.OfficeController;
import ru.bellintegrator.denisov.model.Office;
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
    @RequestMapping(value = "/{orgId:.+}", method = {POST})
    public List<OfficeView> offices(@RequestBody OfficeFilterView view) {
        return officeService.offices(view);
    }

    @Override
    @RequestMapping(value = "/{id:.+}", method = {GET})
    public Office office(@PathVariable("id") String id) {
        return officeService.office(id);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public String update(@RequestBody OfficeView view) {
        try{
            officeService.update(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public String delete(@PathVariable("id") String id) {
        try{
            officeService.delete(id);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public String save(@RequestBody OfficeView view) {
        try{
            officeService.save(view);
            return ResponseView.getSuccesView();
        }catch(Throwable e) {
            return ResponseView.getErrorView(e.getMessage());
        }
    }
    
}
