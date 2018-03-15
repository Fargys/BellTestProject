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
    public List<Organization> all(OrganizationFilterView filter) {
        String name = filter.name;
        String inn = filter.inn;
        String isActive = filter.isActive;

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<Organization> organizations = cq.from(Organization.class);
  
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(
                qb.equal(organizations.get("name"), name));
        }
        if (inn != null) {
            predicates.add(
                qb.equal(organizations.get("inn"), inn));
        }
        if (isActive != null) {
            predicates.add(
                qb.equal(organizations.get("is_active"), isActive));
        }

        cq.select(organizations)
            .where(predicates.toArray(new Predicate[]{}));
        
        return (List) em.createQuery(cq).getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public Organization loadByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> person = criteria.from(Organization.class);
        criteria.where(builder.equal(person.get("name"), name));

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
    
}
