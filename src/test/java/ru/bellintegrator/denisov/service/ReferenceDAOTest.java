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
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.model.Citizenship;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class ReferenceDAOTest {
    
    @Autowired
    private ReferenceDAO referenceDAO;
    
    @Test
    public void test() {
//        DocumentType firstType = new DocumentType();
//        referenceDAO.saveDocument(firstType);
//        List<DocumentType> docs = referenceDAO.allDocumentType();
//        
//        Assert.assertNotNull(docs);
//        Assert.assertFalse(docs.isEmpty());
//        
//        DocumentType secondType = docs.get(1);
//        Assert.assertEquals(firstType, secondType);
//        
//        
//        
//        Citizenship first = new Citizenship();
//        referenceDAO.saveCitizenshipType(first);
//        List<Citizenship> countries = referenceDAO.allCitizenshipType();
//        
//        Assert.assertNotNull(countries);
//        Assert.assertFalse(countries.isEmpty());
//        
//        Citizenship second = countries.get(1);
//        Assert.assertEquals(first, second);
    }
}
