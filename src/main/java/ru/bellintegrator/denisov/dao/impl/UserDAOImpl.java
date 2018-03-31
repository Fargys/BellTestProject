package ru.bellintegrator.denisov.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.denisov.dao.UserDAO;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.DocumentType;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> all() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        List<User> result = query.getResultList();
        
        return result;
    }
    
    @Override
    public List<User> all(UserFilterView filter) {
        UserCriteriaConverter converter = new UserCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<User> users = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();
        
        cq.select(users)
            .where(predicates.toArray(new Predicate[]{}));
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public User loadById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = loadById(id);
        em.remove(user);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }
    
    
    
    private class UserCriteriaConverter {
        private final UserFilterView filter;
        
        private final List<Predicate> predicates = new ArrayList<>();
        private Root<User> users;
        private CriteriaQuery criteriaQuery;
        
        private UserCriteriaConverter(UserFilterView filter) {
            this.filter = filter;
            makePredicates();
        }
        
        
        private void makePredicates() {
            String officeId = filter.officeId;
            String firstName = filter.firstName;
            String lastName = filter.lastName;
            String middleName = filter.middleName;
            String position = filter.position;
            String docCode = filter.docCode;
            String citizenshipCode = filter.citizenshipCode;
            
            CriteriaBuilder qb = em.getCriteriaBuilder();
            criteriaQuery = qb.createQuery();
            users = criteriaQuery.from(User.class);
            
            Root<DocumentType> docs = criteriaQuery.from(DocumentType.class);
            Root<CitizenshipType> countries = criteriaQuery.from(CitizenshipType.class);
            
            if (officeId != null) {
               predicates.add(
                   qb.equal(users.get("office_id"), officeId));
            }
            if (firstName != null) {
               predicates.add(
                   qb.equal(users.get("first_name"), firstName));
            }
            if (lastName != null) {
               predicates.add(
                   qb.equal(users.get("last_name"), lastName));
            }
            if (middleName != null) {
               predicates.add(
                   qb.equal(users.get("middle_name"), middleName));
            }
            if (position != null) {
               predicates.add(
                   qb.equal(users.get("position"), position));
            }
            if (docCode != null) {
               predicates.add(
                   qb.equal(docs.get("doc_code"), docCode));
            }
            if (citizenshipCode != null) {
               predicates.add(
                   qb.equal(countries.get("citizenship_code"), citizenshipCode));
            }
            
        }
        
        
        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<User> getRoot() {
            return users;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }
    }
    
}
