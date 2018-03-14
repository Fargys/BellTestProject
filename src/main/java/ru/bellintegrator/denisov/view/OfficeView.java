package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {
    
    public String id;   
    
    public String name;
    
    public String address;
    
    public String phone;
    
    public Boolean active;
    
    //for jackson
    public OfficeView() {

    }
    
}
