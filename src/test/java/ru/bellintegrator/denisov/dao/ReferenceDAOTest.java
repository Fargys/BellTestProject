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
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;


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
        // test get all document
        List<Document> docs = referenceDAO.getAllDocuments();
        Assert.assertNotNull(docs);
        Assert.assertEquals(2, docs.size());
        
        //test get all citizenships
        List<Citizenship> citizenships = referenceDAO.getAllCitizenships();
        Assert.assertNotNull(citizenships);
        Assert.assertEquals(2, citizenships.size());
        
        // test get document by name
        Document doc = referenceDAO.getDocumentByName("Passport");
        Assert.assertNotNull(doc);
        
        //test get citizenship by name
        Citizenship citizenship = referenceDAO.getCitizenshipByName("Russia");
        Assert.assertNotNull(citizenship);
    }
}
