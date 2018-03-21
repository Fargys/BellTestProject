package ru.bellintegrator.denisov.dao;

import java.util.List;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.Document;

public interface ReferenceDAO {
    
    public List<Document> allDocument();
    
    public List<CitizenshipType> allCitizenship();
}
