package ru.bellintegrator.denisov.view;

public class OfficeFilterView {
    
    public String orgId;
    
    public String name;
    
    public String phone;
    
    Boolean isActive;

    //for jackson
    public OfficeFilterView() {
    }

    @Override
    public String toString() {
        return "name:" + name + "; isActive:" + isActive + "}";
    }
}
