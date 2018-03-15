package ru.bellintegrator.denisov.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;
import ru.bellintegrator.denisov.model.User;

@Repository
public class ReferenceDAOImpl implements ReferenceDAO {
    
    private final EntityManager em;

    @Autowired
    public ReferenceDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Document> allDocument() {
        TypedQuery<User> query = em.createQuery("SELECT p FROM User p", User.class);
        List<User> users = query.getResultList();
        
        List<Document> result = new ArrayList<>();
        
        for(User user : users) result.add(user.getDocument());
        
        return result;
    }

    @Override
    public List<Citizenship> allCitizenship() {
        TypedQuery<User> query = em.createQuery("SELECT p FROM User p", User.class);
        List<User> users = query.getResultList();
        
        List<Citizenship> result = new ArrayList<>();
        
        for(User user : users) result.add(user.getCitizenship());
        
        return result;
    }
    
    
}
