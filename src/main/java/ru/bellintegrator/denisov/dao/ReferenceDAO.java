package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.DocumentType;

public interface ReferenceDAO {
    
    public DocumentType loadDocTypeByName(String docName);
    
    public List<DocumentType> allDocumentType();
    
    public List<CitizenshipType> allCitizenshipType();
}
