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
import ru.bellintegrator.denisov.dao.OrganizationDAO;
import ru.bellintegrator.denisov.exception.OrganizationSeviceException;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.service.OrganizationService;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    
    private final OrganizationDAO orgDAO;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao) {
        this.orgDAO = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> getAllOrganizationByCriteria(OrganizationFilterView filterView) {
        List<OrganizationView> result = new ArrayList<>();
        List<Organization> orgs = orgDAO.getAllOrganizationsByCriteria(filterView);
        
        for(Organization org : orgs) {
            OrganizationView view = org.toConvertFilterOrgDTO();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganizationById(String id) {
        Long orgId = Long.parseLong(id, 10);
        Organization org = orgDAO.getOrganizationById(orgId);
        if(org == null) throw new OrganizationSeviceException("No organization has id = " + id);
        
        OrganizationView view = org.toConvertOrgDTO();
        
        log.info(view.toString());

        return view;
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationView view) {
        Long updatingOrgId = Long.parseLong(view.id, 10);
        Organization org = orgDAO.getOrganizationById(updatingOrgId);
        if(org == null) throw new OrganizationSeviceException("No organization has id = " + updatingOrgId);
        
        org = view.toConvertOrgEntity(org);
        
        orgDAO.updateOrganization(org);
    }

    @Override
    @Transactional
    public void saveOrganization(OrganizationView view) {
        Organization organization = new Organization();
        organization = view.toConvertOrgEntity(organization);
        
        orgDAO.saveOrganization(organization);
    }

    @Override
    @Transactional
    public void deleteOrganization(String id) {
        Long orgId = Long.parseLong(id, 10);
        orgDAO.deleteOrganization(orgId);
    }
    
}
