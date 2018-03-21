package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.bellintegrator.denisov.model.Organization;

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
    
    
    public Organization toConvertOrgEntity(Organization org) {
        
        org.setName(name);
        org.setFullName(fullName);
        org.setInn(inn);
        org.setKpp(kpp);
        org.setAddress(address);
        org.setPhone(phone);
        org.setActive(isActive);
        
        return org;
    }
            
    
    @Override
    public String toString() {
        return "OrganizationView{" + "id=" + id + ", name=" + name + ", fullName=" + fullName + ", inn=" + inn 
                + ", kpp=" + kpp + ", address=" + address + ", phone=" + phone + ", isActive=" + isActive + '}';
    }
    
    
}
