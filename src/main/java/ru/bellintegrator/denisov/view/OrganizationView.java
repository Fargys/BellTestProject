package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationView {
    
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
        return "OrganizationView{" + "id=" + id + ", name=" + name + ", fullName=" + fullName + ", inn=" + inn 
                + ", kpp=" + kpp + ", address=" + address + ", phone=" + phone + ", isActive=" + isActive + '}';
    }
    
    
}
