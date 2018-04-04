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
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.Application;
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
        // test get all
        List<Account> accounts = accountDAO.getAllAccounts();
        Assert.assertNotNull(accounts);
        Assert.assertEquals(2, accounts.size());
        
        // test register
        String testLogin = "testLogin";
        Account account = new Account(testLogin);
        accountDAO.register(account);
        accounts = accountDAO.getAllAccounts();
        Assert.assertEquals(3, accounts.size());
        
        // test get by login
        Account testAccount = accountDAO.loadByLogin(testLogin);
        Assert.assertNotNull(testAccount);
        
        // test get by activation code
        testAccount = accountDAO.loadByActivationCode("somecode #1");
        Assert.assertNotNull(testAccount);
    }
}
