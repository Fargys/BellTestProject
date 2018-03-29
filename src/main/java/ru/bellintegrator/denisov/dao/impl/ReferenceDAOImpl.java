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
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.DocumentType;

@Repository
public class ReferenceDAOImpl implements ReferenceDAO {
    
    private final EntityManager em;

    @Autowired
    public ReferenceDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public DocumentType loadDocTypeByName(String docName) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = builder.createQuery(DocumentType.class);

        Root<DocumentType> account = criteria.from(DocumentType.class);
        criteria.where(builder.equal(account.get("doc_name"), docName));

        TypedQuery<DocumentType> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
    
    @Override
    public List<DocumentType> allDocumentType() {
        TypedQuery<DocumentType> query = em.createNamedQuery("DocumentType.findAll", DocumentType.class);
        List<DocumentType> result = query.getResultList();
        
        return result;
    }

    @Override
    public List<CitizenshipType> allCitizenshipType() {
        TypedQuery<CitizenshipType> query = em.createNamedQuery("CitizenshipType.findAll", CitizenshipType.class);
        List<CitizenshipType> result = query.getResultList();
        
        return result;
    }
    
}
