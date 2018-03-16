package ru.bellintegrator.denisov.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;

@Repository
public class ReferenceDAOImpl implements ReferenceDAO {
    
    private final EntityManager em;

    @Autowired
    public ReferenceDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Document> allDocument() {
        TypedQuery<Document> query = em.createQuery("SELECT p FROM Document p", Document.class);
        List<Document> result = query.getResultList();
        
        return result;
    }

    @Override
    public List<Citizenship> allCitizenship() {
        TypedQuery<Citizenship> query = em.createQuery("SELECT p FROM Citizenship p", Citizenship.class);
        List<Citizenship> result = query.getResultList();
        
        return result;
    }
    
    
}
