package ru.bellintegrator.denisov.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {
    @ApiModelProperty(hidden = true)
    public String id;
    
    public String name;
    
    public String fullName;
    
    public Integer inn;
    
    public Integer kpp;
            
    public String address;
            
    public String phone;
    
    public Boolean isActive;
    
    //for jackson
    public OrganizationView() {

    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + name + "; fullName:" + fullName + "; inn:" + inn 
                + "; kpp:" + kpp + "; address:" + address + "; phone:" + phone + "; active:" + isActive + "}";
    }
}
