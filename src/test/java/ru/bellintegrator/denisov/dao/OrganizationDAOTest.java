package ru.bellintegrator.denisov.dao;

import java.util.List;
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
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OrganizationFilterView;



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
        //test get all
        List<Organization> orgs = organizationDAO.getAllOrganizations();
        Assert.assertNotNull(orgs);
        Assert.assertEquals(2, orgs.size());
        
        // test get all with criteria
        OrganizationFilterView criteria = new OrganizationFilterView("MC");
        List<Organization> orgsByCriteria = organizationDAO.getAllOrganizationsByCriteria(criteria);
        Assert.assertNotNull(orgsByCriteria);
        Assert.assertEquals(1, orgsByCriteria.size());
        
        //test save
        String testName = "testName";
        Organization saveTestOrg = new Organization(testName);
        organizationDAO.saveOrganization(saveTestOrg);
        orgs = organizationDAO.getAllOrganizations();
        Assert.assertEquals(3, orgs.size());
        
        //test update
        Organization updateTestOrg = organizationDAO.getOrganizationByName(testName);
        Assert.assertNotNull(updateTestOrg);
        String nameForUpdate = "newTestName";
        updateTestOrg.setName(nameForUpdate);
        organizationDAO.updateOrganization(updateTestOrg);
        Organization orgAfterUpdate = organizationDAO.getOrganizationByName(nameForUpdate);
        Assert.assertNotNull(orgAfterUpdate);
        
        //test delete
        organizationDAO.deleteOrganization(1L);
        orgs = organizationDAO.getAllOrganizations();
        Assert.assertEquals(2, orgs.size());
        
    }
}
