package ru.bellintegrator.denisov.view;


public class OrganizationSaveView {
    public String name;
    
    public String fullName;
    
    public Integer inn;
    
    public Integer kpp;
            
    public String address;
            
    public String phone;
    
    public Boolean isActive;
    
    //for jackson
    public OrganizationSaveView() {

    }

    @Override
    public String toString() {
        return "{name:" + name + "; fullName:" + fullName + "; inn:" + inn + "; kpp:" + kpp + "; address:" 
                + address + "; phone:" + phone + "; active:" + isActive + "}";
    }
}
