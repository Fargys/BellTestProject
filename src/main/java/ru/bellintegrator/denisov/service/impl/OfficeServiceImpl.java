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
import ru.bellintegrator.denisov.dao.OrganizationDAO;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.service.OfficeService;
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);
    
    private final OfficeDAO officeDAO;
    private final OrganizationDAO orgDAO;
    
    @Autowired
    public OfficeServiceImpl(OfficeDAO officeDAO, OrganizationDAO orgDAO) {
        this.officeDAO = officeDAO;
        this.orgDAO = orgDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices(OfficeFilterView filterView) {
        List<OfficeView> result = new ArrayList<>();
        List<Office> offices = officeDAO.all(filterView);
        
        for(Office office : offices) {
            OfficeView view = office.toConvertFilterOfficeDTO();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView office(String id) {
        Long orgId = Long.parseLong(id, 10);
        Office office = officeDAO.loadById(orgId);
        
        OfficeView view = office.toConvertOfficeDTO();
        
        log.info(view.toString());

        return view;
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
        Long updatingOfficeId = Long.parseLong(view.id, 10);
        Office office = officeDAO.loadById(updatingOfficeId);
        office = view.toConvertOfficeEntity(office);
        
        officeDAO.update(office);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Long officeId = Long.parseLong(id, 10);
        officeDAO.delete(officeId);
    }

    @Override
    @Transactional
    public void save(OfficeView view) {
        Long orgId = Long.parseLong(view.orgId);
        Organization org = orgDAO.loadById(orgId);
        
        Office office = new Office();
        office = view.toConvertOfficeEntity(office, org);
        
        officeDAO.save(office);
    }
    
}
