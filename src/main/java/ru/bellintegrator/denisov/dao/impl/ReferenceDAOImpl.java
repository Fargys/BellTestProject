package ru.bellintegrator.denisov.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public Document getDocumentByName(String docName) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Document> criteria = builder.createQuery(Document.class);

        Root<Document> account = criteria.from(Document.class);
        criteria.where(builder.equal(account.get("doc_name"), docName));

        TypedQuery<Document> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
    
    @Override
    public Citizenship getCitizenshipByName(String countryName) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Citizenship> criteria = builder.createQuery(Citizenship.class);

        Root<Citizenship> account = criteria.from(Citizenship.class);
        criteria.where(builder.equal(account.get("countryName"), countryName));

        TypedQuery<Citizenship> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
    
    @Override
    public List<Document> getAllDocuments() {
        TypedQuery<Document> query = em.createNamedQuery("Document.findAll", Document.class);
        List<Document> result = query.getResultList();
        
        return result;
    }

    @Override
    public List<Citizenship> getAllCitizenship() {
        TypedQuery<Citizenship> query = em.createNamedQuery("CitizenshipType.findAll", Citizenship.class);
        List<Citizenship> result = query.getResultList();
        
        return result;
    }

//    @Override
//    public void saveDocument(Document document) {
//        em.persist(document);
//    }
//
//    @Override
//    public void saveCitizenshipType(Citizenship country) {
//        em.persist(country);
//    }
    
}
