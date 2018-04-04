package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;

public interface ReferenceService {

    public List<Document> getAllDocuments();

    public List<Citizenship> getAllCitizenships();
    
}
