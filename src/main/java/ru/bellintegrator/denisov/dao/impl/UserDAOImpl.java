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
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        List<User> result = query.getResultList();
        
        return result;
    }
    
    @Override
    public List<User> getAllUsersByCriteria(UserFilterView filter) {
        UserCriteriaConverter converter = new UserCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<User> users = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();
        
        cq.select(users)
            .where(predicates.toArray(new Predicate[]{}));
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> user = criteria.from(User.class);
        criteria.where(builder.equal(user.get("firstName"), name));

        TypedQuery<User> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
    
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        em.remove(user);
    }

    @Override
    public void saveUser(User user) {
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
            
          if (officeId != null) {
               predicates.add(
                   qb.equal(users.get("office").get("id"), officeId));
            }
            if (firstName != null) {
               predicates.add(
                   qb.equal(users.get("firstName"), firstName));
            }
            if (lastName != null) {
               predicates.add(
                   qb.equal(users.get("lastName"), lastName));
            }
            if (middleName != null) {
               predicates.add(
                   qb.equal(users.get("middleName"), middleName));
            }
            if (position != null) {
               predicates.add(
                   qb.equal(users.get("position"), position));
            }
            if (docCode != null) {
               predicates.add(
                   qb.equal(users.get("document").get("docCode"), docCode));
            }
            if (citizenshipCode != null) {
               predicates.add(
                   qb.equal(users.get("citizenship").get("countryCode"), citizenshipCode));
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
