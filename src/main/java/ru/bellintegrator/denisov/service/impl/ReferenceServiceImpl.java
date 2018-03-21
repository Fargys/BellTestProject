package ru.bellintegrator.denisov.service.impl;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.Document;
import ru.bellintegrator.denisov.service.ReferenceService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ReferenceServiceImpl implements ReferenceService {
    
    private final ReferenceDAO dao;

    public ReferenceServiceImpl(ReferenceDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Document> documents() {
        return dao.allDocument();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitizenshipType> countries() {
        return dao.allCitizenship();
    }
 
    
    
}
