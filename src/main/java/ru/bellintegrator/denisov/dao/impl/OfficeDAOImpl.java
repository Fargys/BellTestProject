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
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.view.OfficeFilterView;

@Repository
public class OfficeDAOImpl implements OfficeDAO {
    
    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em) {
        this.em = em;
    }

    
    @Override
    public List<Office> getAllOffices() {
        TypedQuery<Office> query = em.createNamedQuery("Office.findAll", Office.class);
        List<Office> result = query.getResultList();
        
        return result;
    }
    
    @Override
    public List<Office> getAllOfficesByCriteria(OfficeFilterView filter) {
        OfficeCriteriaConverter converter = new OfficeCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<Office> office = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();
        
        cq.select(office)
            .where(predicates.toArray(new Predicate[]{}));
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Office getOfficeById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public Office getOfficeByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);

        Root<Office> office = criteria.from(Office.class);
        criteria.where(builder.equal(office.get("name"), name));

        TypedQuery<Office> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
    
    @Override
    public void updateOffice(Office office) {
        em.merge(office);
    }

    @Override
    public void deleteOffice(Long id) {
        Office office = getOfficeById(id);
        em.remove(office);
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }
    
    
    private class OfficeCriteriaConverter {
        private final OfficeFilterView filter;
        
        private final List<Predicate> predicates = new ArrayList<>();
        private Root<Office> office;
        private CriteriaQuery criteriaQuery;

        public OfficeCriteriaConverter(OfficeFilterView filter) {
            this.filter = filter;
            makePredicates();
        }
        
        private void makePredicates() {
            String orgId = filter.orgId;
            String name = filter.name;
            String phone = filter.phone;
            String isActive = filter.isActive;

            CriteriaBuilder qb = em.getCriteriaBuilder();
            criteriaQuery = qb.createQuery();
            office = criteriaQuery.from(Office.class);
            
            
            if (orgId != null) {
               predicates.add(
                   qb.equal(office.get("organization").get("id"), orgId));
            }
            if (name != null) {
               predicates.add(
                   qb.like(office.get("name"), "%" + name + "%"));
            }
            if (phone != null) {
                predicates.add(
                  qb.equal(office.get("phone"), phone));
            }
            if (isActive != null) {
                predicates.add(
                  qb.equal(office.get("isActive"), isActive));
            }
        }
        

        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<Office> getRoot() {
            return office;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }
        
    }
    
}
