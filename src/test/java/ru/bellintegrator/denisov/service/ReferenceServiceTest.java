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
import ru.bellintegrator.denisov.main.Application;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.DocumentType;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class ReferenceServiceTest {
    
    @Autowired
    private ReferenceDAO referenceDAO;
    
    @Test
    public void test() {
        DocumentType firstType = new DocumentType();
        referenceDAO.saveDocument(firstType);
        List<DocumentType> docs = referenceDAO.allDocumentType();
        
        Assert.assertNotNull(docs);
        Assert.assertFalse(docs.isEmpty());
        
        DocumentType secondType = docs.get(1);
        Assert.assertEquals(firstType, secondType);
        
        
        
        CitizenshipType first = new CitizenshipType();
        referenceDAO.saveCitizenshipType(first);
        List<CitizenshipType> countries = referenceDAO.allCitizenshipType();
        
        Assert.assertNotNull(countries);
        Assert.assertFalse(countries.isEmpty());
        
        CitizenshipType second = countries.get(1);
        Assert.assertEquals(first, second);
    }
}
