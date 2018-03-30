package ru.bellintegrator.denisov.service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.DocumentType;

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
