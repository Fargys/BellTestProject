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
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationServiceTest {
    
    @Autowired
    OrganizationService orgService;
    
    
    @Test
    public void testGetOrganizationById() {
        OrganizationView view = orgService.getOrganizationById("1");
        Assert.assertNotNull(view);
        Assert.assertEquals("MC", view.name);
    }
    
    @Test
    public void testGetAllOrganizationByCriteria() {
        OrganizationFilterView filter = new OrganizationFilterView("M");
        List<OrganizationView> list = orgService.getAllOrganizationByCriteria(filter);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        
        OrganizationView response = list.get(0);
        Assert.assertEquals("MC", response.name);
        }
    
    }
