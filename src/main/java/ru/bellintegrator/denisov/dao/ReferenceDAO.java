package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;

public interface ReferenceDAO {
    
    public Document getDocumentByName(String docName);
    
    public Citizenship getCitizenshipByName(String citizenshipName);
    
    public List<Document> getAllDocuments();
    
    public List<Citizenship> getAllCitizenship();
}
