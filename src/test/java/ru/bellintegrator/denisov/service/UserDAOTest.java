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
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.model.Office;
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
    @Autowired
    private OfficeDAO officeDAO;
    
    @Test
    public void test() {
        //test get all
        List<User> users = userDAO.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
        
        // test get all with criteria
        UserFilterView criteria = new UserFilterView("Walter");
        List<User> usersByCriteria = userDAO.getAllUsersByCriteria(criteria);
        Assert.assertNotNull(usersByCriteria);
        Assert.assertEquals(1, usersByCriteria.size());
        
        //test save
        String testName = "testName";
        User saveTestUser = new User(testName);
        Office office = officeDAO.getOfficeById(1L);
        saveTestUser.setOffice(office);
        userDAO.saveUser(saveTestUser);
        users = userDAO.getAllUsers();
        Assert.assertEquals(3, users.size());
        
        //test update
        User updateTestUser = userDAO.getUserByName(testName);
        Assert.assertNotNull(updateTestUser);
        String nameForUpdate = "newTestName";
        updateTestUser.setFirstName(nameForUpdate);
        userDAO.updateUser(updateTestUser);
        User userAfterUpdate = userDAO.getUserByName(nameForUpdate);
        Assert.assertNotNull(userAfterUpdate);
        
        //delete not working
        userDAO.deleteUser(1L);
        users = userDAO.getAllUsers();
        Assert.assertEquals(2, users.size());
    }
}
