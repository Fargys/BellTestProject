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
    public List<OrganizationView> organizations(OrganizationFilterView filterView) {
        List<OrganizationView> result = new ArrayList<>();
        List<Organization> orgs = orgDAO.all(filterView);
        
        for(Organization org : orgs) {
            OrganizationView view = org.toConvertFilterOrgDTO();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView organization(String id) {
        Long orgId = Long.parseLong(id, 10);
        Organization org = orgDAO.loadById(orgId);
        
        OrganizationView view = org.toConvertOrgDTO();
        
        log.info(view.toString());

        return view;
    }

    @Override
    @Transactional
    public void update(OrganizationView view) {
        Long updatingOrgId = Long.parseLong(view.id, 10);
        Organization organization = orgDAO.loadById(updatingOrgId);
        organization = view.toConvertOrgEntity(organization);
        
        orgDAO.update(organization);
    }

    @Override
    @Transactional
    public void save(OrganizationView view) {
        Organization organization = new Organization();
        organization = view.toConvertOrgEntity(organization);
        
        orgDAO.save(organization);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Long orgId = Long.parseLong(id, 10);
        orgDAO.delete(orgId);
    }
    
}
