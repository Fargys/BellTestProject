package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;

public interface ReferenceDAO {
    
    public Document loadDocTypeByName(String docName);
    
    public List<Document> allDocumentType();
    
    public void saveDocument(Document type);
    
    public List<Citizenship> allCitizenshipType();
    
    public void saveCitizenshipType(Citizenship type);
}
