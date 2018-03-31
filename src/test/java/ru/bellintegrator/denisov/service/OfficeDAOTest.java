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
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDAOTest {
    
    @Autowired
    private OfficeDAO officeDAO;
    
    @Test
    public void test() {
        Office office = new Office();
        Set<User> list = new HashSet<>();
        office.setAddress("Address");
        User user = new User();
        user.setOffice(office);
        office.setUsers(list);
        list.add(user);
        officeDAO.save(office);

        List<Office> offices = officeDAO.all();
        Assert.assertNotNull(offices);

        user.setOffice(office);

        Assert.assertFalse(offices.isEmpty());

        Set<User> users = offices.get(1).getUsers();
        
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());

        User secondUser = new User();
        users.add(secondUser);

        offices = officeDAO.all();
        users = offices.get(1).getUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
    }
    
}
