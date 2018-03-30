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
import ru.bellintegrator.denisov.dao.UserDAO;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.Document;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.view.UserFilterView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserDAOTest {
    
    @Autowired
    private UserDAO userDAO;
    
    @Test
    public void test() {
        User user = new User();
        user.setPosition("Manager");
        
        Document userDoc = new Document();
        CitizenshipType userCountry = new CitizenshipType();  
        
        user.setDocument(userDoc);
        user.setCitizenship(userCountry);
        
        userDAO.save(user);
        
        List<User> users = userDAO.all(new UserFilterView());
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(1, users.size());
        
        userDoc = users.get(1).getDocument();
        Assert.assertNotNull(userDoc);
        
        userCountry = users.get(1).getCitizenship();
        Assert.assertNotNull(userCountry);
    }
}
