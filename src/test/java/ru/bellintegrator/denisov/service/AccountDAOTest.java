package ru.bellintegrator.denisov.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.main.Application;
import ru.bellintegrator.denisov.model.Account;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class AccountDAOTest {
    
    @Autowired
    private AccountDAO accountDAO;
    
    @Test
    public void test() {
        Account account = new Account();
        String activationCode = "activation";
        
        account.setActivationCode(activationCode);
        accountDAO.register(account);
        
        Account secondAccount = accountDAO.loadByActivationCode(activationCode);
        Assert.assertNotNull(secondAccount);
        
        Assert.assertEquals(account, secondAccount);
    }
}
