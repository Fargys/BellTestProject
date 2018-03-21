package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.Organization;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {
    
    public String id;   
    
    public String name;
    
    public String address;
    
    public String phone;
    
    public Boolean isActive;
    
    public String orgId;

    public Office toConvertOfficeEntity(Office office) {
        
        office.setName(name);
        office.setAddress(address);
        office.setPhone(phone);
        office.setActive(isActive);
        
        return office;
    }

    public Office toConvertOfficeEntity(Office office, Organization org) {
        
        office.setName(name);
        office.setAddress(address);
        office.setPhone(phone);
        office.setActive(isActive);
        office.setOrganization(org);
        
        return office;
    }
    
    
    @Override
    public String toString() {
        return "OfficeView{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone 
                + ", isActive=" + isActive + ", orgId=" + orgId + '}';
    }
    
}
