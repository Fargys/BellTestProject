package ru.bellintegrator.denisov.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeUpdateView {
    @ApiModelProperty(hidden = true)
    public String id;   
    
    public String name;
    
    public String address;
    
    public String phone;
    
    public Boolean active;
    
    //for jackson
    public OfficeUpdateView() {

    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + name + "; address:" + address + "; phone:" + phone + "; active:" + active + '}';
    }
}
