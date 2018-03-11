package ru.bellintegrator.denisov.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
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
import ru.bellintegrator.denisov.view.OrganizationUpdateView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    
    private final OrganizationDAO dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationUpdateView> organizations() {
        List<Organization> all = dao.all();
        
        Function<Organization, OrganizationUpdateView> mapOrganization = p -> {
            OrganizationUpdateView view = new OrganizationUpdateView();
            view.id = String.valueOf(p.getId());
            view.name = p.getName();
            view.fullName = p.getFullName();
            view.inn = p.getInn();
            view.kpp = p.getKpp();
            view.address = p.getAddress();
            view.phone = p.getPhone();
            view.active = p.isActive();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Organization organization(Long id) {
        Organization organization = dao.loadById(id);
        return organization;
    }

    @Override
    @Transactional
    public void update(OrganizationUpdateView view) {
        Long updatingOrgId = Long.parseLong(view.id, 10);
        Organization organization = dao.loadById(updatingOrgId);
        
        organization.setName(view.name);
        organization.setFullName(view.fullName);
        organization.setInn(view.inn);
        organization.setKpp(view.kpp);
        organization.setAddress(view.address);
        organization.setPhone(view.phone);
        organization.setActive(true);
        
        dao.update(organization);
    }

    @Override
    @Transactional
    public void save(OrganizationUpdateView view) {
        Organization organization = new Organization();
        
        organization.setName(view.name);
        organization.setFullName(view.fullName);
        organization.setInn(view.inn);
        organization.setKpp(view.kpp);
        organization.setAddress(view.address);
        organization.setPhone(view.phone);
        organization.setActive(true);
        
        dao.save(organization);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
