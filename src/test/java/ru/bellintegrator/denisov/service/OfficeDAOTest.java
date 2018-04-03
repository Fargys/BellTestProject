package ru.bellintegrator.denisov.service;

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
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.dao.OrganizationDAO;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.Organization;
import ru.bellintegrator.denisov.view.OfficeFilterView;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDAOTest {
    
    @Autowired
    private OfficeDAO officeDAO;
    @Autowired
    private OrganizationDAO organizationDAO;
    
    @Test
    public void test() {
        //test get all
        List<Office> offices = officeDAO.getAllOffices();
        Assert.assertNotNull(offices);
        Assert.assertEquals(2, offices.size());
        
        // test get all with criteria
        OfficeFilterView criteria = new OfficeFilterView("#1");
        List<Office> officesByCriteria = officeDAO.getAllOfficesByCriteria(criteria);
        Assert.assertNotNull(officesByCriteria);
        Assert.assertEquals(1, officesByCriteria.size());
        
        //test save
        String testName = "testName";
        Office saveTestOffice = new Office(testName);
        Organization org = organizationDAO.getOrganizationById(1L);
        saveTestOffice.setOrganization(org);
        officeDAO.saveOffice(saveTestOffice);
        offices = officeDAO.getAllOffices();
        Assert.assertEquals(3, offices.size());
        
        //test update
        Office updateTestOffice = officeDAO.getOfficeByName(testName);
        Assert.assertNotNull(updateTestOffice);
        String nameForUpdate = "newTestName";
        updateTestOffice.setName(nameForUpdate);
        officeDAO.updateOffice(updateTestOffice);
        Office officeAfterUpdate = officeDAO.getOfficeByName(nameForUpdate);
        Assert.assertNotNull(officeAfterUpdate);
        
        //test delete not working
        officeDAO.deleteOffice(1L);
        offices = officeDAO.getAllOffices();
        Assert.assertEquals(2, offices.size());
    }
    
}
