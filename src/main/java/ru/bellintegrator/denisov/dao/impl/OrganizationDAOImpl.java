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
import ru.bellintegrator.denisov.dao.OrganizationDAO;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationFilterView;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
    
    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createNamedQuery("Organization.findAll", Organization.class);
        List<Organization> result = query.getResultList();
        
        return result;
    }
    
    @Override
    public List<Organization> all(OrganizationFilterView filter) {
        OrgCriteriaConverter converter = new OrgCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<Organization> organizations = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();

        cq.select(organizations)
            .where(predicates.toArray(new Predicate[]{}));
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public Organization loadByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organization = criteria.from(Organization.class);
        criteria.where(builder.equal(organization.get("name"), name));

        TypedQuery<Organization> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void delete(Long id) {
        Organization org = loadById(id);
        em.remove(org);
    }
    
    
    private class OrgCriteriaConverter {
        private final OrganizationFilterView filter;
        
        private final List<Predicate> predicates = new ArrayList<>();
        private Root<Organization> organizations;
        private CriteriaQuery criteriaQuery;

        public OrgCriteriaConverter(OrganizationFilterView filter) {
            this.filter = filter;
            makePredicates();
        }
        
        private void makePredicates() {
            String name = filter.name;
            String inn = filter.inn;
            String isActive = filter.isActive;

            CriteriaBuilder qb = em.getCriteriaBuilder();
            criteriaQuery = qb.createQuery();
            organizations = criteriaQuery.from(Organization.class);
            
            if (name != null) {
               predicates.add(
                   qb.like(organizations.<String>get("name"), name));
            }
            if (inn != null) {
                predicates.add(
                  qb.equal(organizations.get("inn"), inn));
            }
            if (isActive != null) {
                predicates.add(
                  qb.equal(organizations.get("is_active"), isActive));
            }
        }
        

        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<Organization> getRoot() {
            return organizations;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }
        
    }
    
}
