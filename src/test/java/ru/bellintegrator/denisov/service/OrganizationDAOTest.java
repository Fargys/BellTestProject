package ru.bellintegrator.denisov.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.dao.OrganizationDAO;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.Organization;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDAOTest {
    
    @Autowired
    private OrganizationDAO organizationDAO;
    
    @Test
    public void test() {
        Organization organization = new Organization();
        Set<Office> list = new HashSet<>();
        organization.setAddress("Address");
        Office office = new Office();
        office.setOrganization(organization);
        organization.setOffices(list);
        list.add(office);
        organizationDAO.save(organization);

        List<Organization> organizations = organizationDAO.all();
        Assert.assertNotNull(organizations);

        office.setOrganization(organization);

        Assert.assertFalse(organizations.isEmpty());

        Set<Office> offices = organizations.get(1).getOffices();
        
        Assert.assertNotNull(offices);
        Assert.assertEquals(1, offices.size());

        Office secondOffice = new Office();
        offices.add(secondOffice);

        organizations = organizationDAO.all();
        offices = organizations.get(1).getOffices();
        Assert.assertNotNull(offices);
        Assert.assertEquals(1, offices.size());
    }
}
