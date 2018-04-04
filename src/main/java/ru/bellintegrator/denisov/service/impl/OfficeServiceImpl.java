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
import ru.bellintegrator.denisov.exception.OfficeSeviceException;
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
    public List<OfficeView> getAllOfficesByCriteria(OfficeFilterView filterView) {
        List<OfficeView> result = new ArrayList<>();
        List<Office> offices = officeDAO.getAllOfficesByCriteria(filterView);
        
        for(Office office : offices) {
            OfficeView view = office.toConvertFilterOfficeDTO();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOfficeById(String id) {
        Long orgId = Long.parseLong(id, 10);
        Office office = officeDAO.getOfficeById(orgId);
        if(office == null) throw new OfficeSeviceException("No office has id = " + id);
        
        OfficeView view = office.toConvertOfficeDTO();
        
        log.info(view.toString());

        return view;
    }

    @Override
    @Transactional
    public void updateOffice(OfficeView view) {
        Long updatingOfficeId = Long.parseLong(view.id, 10);
        Office office = officeDAO.getOfficeById(updatingOfficeId);
        if(office == null) throw new OfficeSeviceException("No office has id = " + updatingOfficeId);
        
        office = view.toConvertOfficeEntity(office);
        
        officeDAO.updateOffice(office);
    }

    @Override
    @Transactional
    public void deleteOffice(String id) {
        Long officeId = Long.parseLong(id, 10);
        officeDAO.deleteOffice(officeId);
    }

    @Override
    @Transactional
    public void saveOffice(OfficeView view) {
        Long orgId = Long.parseLong(view.orgId);
        if(orgId == null) throw new OfficeSeviceException("No organization has id = " + orgId);
        
        Organization org = orgDAO.getOrganizationById(orgId);
        
        Office office = view.toConvertOfficeEntity(org);
        
        officeDAO.saveOffice(office);
    }
    
}
