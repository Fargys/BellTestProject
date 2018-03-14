package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {
    
    public String id;   
    
    public String name;
    
    public String address;
    
    public String phone;
    
    public Boolean isActive;
    

    @Override
    public String toString() {
        return "OfficeView{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone 
                + ", isActive=" + isActive + '}';
    }
    
    
}
