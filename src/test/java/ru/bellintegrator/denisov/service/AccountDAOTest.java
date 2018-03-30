package ru.bellintegrator.denisov.service;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.model.Account;

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
