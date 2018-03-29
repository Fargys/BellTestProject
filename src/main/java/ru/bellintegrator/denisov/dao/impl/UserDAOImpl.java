package ru.bellintegrator.denisov.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
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
        private UserFilterView filter;
        
        private List<Predicate> predicates = new ArrayList<>();
        private Root<User> organizations;
        private CriteriaQuery criteriaQuery;
        
        private UserCriteriaConverter(UserFilterView filter) {
            this.filter = filter;
        }
        
        
        private void makePredicates() {
            //TODO
        }
        
        
        
        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<User> getRoot() {
            return organizations;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }
    }
    
}
