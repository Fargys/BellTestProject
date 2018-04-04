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
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserServiceTest {
    
    @Autowired
    UserService userService;
    
    
    @Test
    public void testGetUserById() {
        UserView view = userService.getUserById("1");
        Assert.assertNotNull(view);
        Assert.assertEquals("Walter", view.firstName);
    }
    
    @Test
    public void testGetAllUsersByCriteria() {
        UserFilterView filter = new UserFilterView("Walter");
        List<UserView> list = userService.getAllUsersByCriteria(filter);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        
        UserView response = list.get(0);
        Assert.assertEquals("Walter", response.firstName);
    }
    
}
