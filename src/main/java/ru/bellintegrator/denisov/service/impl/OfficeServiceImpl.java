package ru.bellintegrator.denisov.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.service.OfficeService;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);
    
    private final OfficeDAO dao;
    
    @Autowired
    public OfficeServiceImpl(OfficeDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices(OfficeFilterView filterView) {
        List<OfficeView> result = new ArrayList<>();
        List<Office> offices = dao.all(filterView);
        
        for(Office office : offices) {
            OfficeView view = new OfficeView();
            
            view.id = String.valueOf(office.getId());
            view.name = office.getName();
            view.isActive = office.isActive();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
        
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView office(String id) {
        Long orgId = Long.parseLong(id, 10);
        Office office = dao.loadById(orgId);
        
        OfficeView view = new OfficeView();
        
        view.id = String.valueOf(office.getId());
        view.name = office.getName();
        view.address = office.getAddress();
        view.phone = office.getPhone();
        view.isActive = office.isActive();
        
        log.info(view.toString());

        return view;
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
        Long updatingOfficeId = Long.parseLong(view.id, 10);
        Office office = dao.loadById(updatingOfficeId);
        
        office.setName(view.name);
        office.setPhone(view.phone);
        office.setActive(view.isActive);
        
        dao.update(office);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Long officeId = Long.parseLong(id, 10);
        dao.delete(officeId);
    }

    @Override
    @Transactional
    public void save(OfficeView view) {
        Office office = new Office();
        
        office.setName(view.name);
        office.setPhone(view.phone);
        office.setActive(true);
        
        dao.save(office);
    }
    
}
