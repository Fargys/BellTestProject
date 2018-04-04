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
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeServiceTest {
    
    @Autowired
    OfficeService officeService;
    
    
    @Test
    public void testGetOfficeById() {
        OfficeView view = officeService.getOfficeById("1");
        Assert.assertNotNull(view);
        Assert.assertEquals("Office #1", view.name);
    }
    
     @Test
    public void testGetAllOfficesByCriteria() {
        OfficeFilterView filter = new OfficeFilterView("#1");
        List<OfficeView> list = officeService.getAllOfficesByCriteria(filter);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        
        OfficeView response = list.get(0);
        Assert.assertEquals("Office #1", response.name);
    }

}
