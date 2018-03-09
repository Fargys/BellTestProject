package ru.bellintegrator.denisov.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.denisov.controller.OfficeController;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.service.OfficeService;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {
    
    private final OfficeService officeService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeSerivce) {
        this.officeService = officeSerivce;
    }
    

    @Override
    @RequestMapping(value = "/api/office/list/{orgId:.+}", method = {POST})
    public List<Office> offices(Long orgId, String name, String phone, Boolean isActive) {
        return officeService.offices();
    }

    @Override
    @RequestMapping(value = "/api/office/{id:.+}", method = {GET})
    public Office office(Long officeId) {
        return officeService.office();
    }

    @Override
    @RequestMapping(value = "/api/office/update", method = {POST})
    public String update(Long officeId, String name, String address, String phone, Boolean isActive) {
        return officeService.update();
    }

    @Override
    @RequestMapping(value = "/api/office/delete", method = {POST})
    public String delete(Long officeId) {
        return officeService.delete();
    }

    @Override
    @RequestMapping(value = "/api/office/save", method = {POST})
    public String save(String name, String address, String phone, Boolean isActive) {
        return officeService.save();
    }
    
    
}
