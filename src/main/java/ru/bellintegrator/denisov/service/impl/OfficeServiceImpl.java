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
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.service.OfficeService;
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
    public List<OfficeView> offices() {
        List<Office> all = dao.all();
        
        Function<Office, OfficeView> mapOrganization = p -> {
            OfficeView view = new OfficeView();
            view.id = String.valueOf(p.getId());
            view.name = p.getName();
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
    public Office office(Long id) {
        Office office = dao.loadById(id);
        return office;
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
        Long updatingOfficeId = Long.parseLong(view.id, 10);
        Office office = dao.loadById(updatingOfficeId);
        
        office.setName(view.name);
        office.setPhone(view.phone);
        office.setActive(true);
        
        dao.update(office);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
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
