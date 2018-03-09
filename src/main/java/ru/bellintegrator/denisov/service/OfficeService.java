package ru.bellintegrator.denisov.service;

import java.util.List;
import ru.bellintegrator.denisov.model.Office;

public interface OfficeService {
    public List<Office> offices();

    public Office office();

    public String update();

    public String delete();

    public String save();
    
}
