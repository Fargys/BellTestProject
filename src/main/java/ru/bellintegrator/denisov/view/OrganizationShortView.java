package ru.bellintegrator.denisov.view;


public class OrganizationFiltertView {
    
    public String name;
    
    public Integer inn;
    
    public Boolean isActive;

    //for jackson
    public OrganizationFiltertView() {
    }

    @Override
    public String toString() {
        return "name:" + name + "; active;" + isActive + "}";
    }
}
