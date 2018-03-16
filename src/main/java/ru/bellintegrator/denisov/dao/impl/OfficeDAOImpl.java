package ru.bellintegrator.denisov.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
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
    public List<Office> all(OfficeFilterView filter) {
        String orgId = filter.orgId;
        String name = filter.name;
        String phone = filter.phone;
        String isActive = String.valueOf(filter.isActive);

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<Office> office = cq.from(Office.class);
  
        List<Predicate> predicates = new ArrayList<>();

        if (orgId != null) {
            predicates.add(
                qb.equal(office.get("org_id"), orgId));
        }
        if (name != null) {
            predicates.add(
                qb.like(office.<String>get("name"), name));
        }
        if (phone != null) {
            predicates.add(
                qb.equal(office.get("phone"), phone));
        }
        if (isActive != null) {
            predicates.add(
                qb.equal(office.get("is_active"), isActive));
        }

        cq.select(office)
            .where(predicates.toArray(new Predicate[]{}));
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void update(Office office) {
        em.merge(office);
    }

    @Override
    public void delete(Long id) {
        Office office = loadById(id);
        em.remove(office);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }
    
}
